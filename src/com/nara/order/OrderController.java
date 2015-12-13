package com.nara.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nara.common.service.MainService;
import com.nara.framework.util.SoftUtil;
import com.nara.order.service.OrderService;
import com.nara.order.vo.AddOrder;
import com.nara.order.vo.AddOrderDetail;
import com.nara.sales.service.SalesService;


@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	private static SoftUtil util = new SoftUtil();
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private MainService mainService;
	@Autowired
	private SalesService salesService;
	
	
	@RequestMapping("/order/order")
	public void order(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {

		log.info("map : " + paramMap.toString());
		
		List menuList = orderService.getMenuList(paramMap);
		model.addAttribute("menuList",menuList);
		
		String phone = util.print((String)paramMap.get("phone"));
		String address = util.print((String)paramMap.get("address"));
		String cust_no = util.print((String)paramMap.get("cust_no"));
		
		if("".equals(cust_no))
			paramMap.put("cust_no", "0");
		
		//Convert List to Map
		List<Map<String,Object>> userInfo;
		userInfo = orderService.getCustomerInfo(paramMap);
		
		Map<String,Object> customerInfo = new HashMap<String, Object>();
		for( Map<String, Object> customerInfo1 : userInfo){
			for(Map.Entry<String, Object> entry: customerInfo1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				customerInfo.put(key, value);
			}
		}
		
		
		String flag = util.print(customerInfo.get("CUST_NO"));
		
		if("".equals(flag)){
			model.put("phone",phone);
			model.put("address",address);
		}
		else{
			System.out.println("*********************************\n[debug] cust_no : "+customerInfo.get("CUST_NO"));
			model.put("phone",customerInfo.get("PHONE"));
			model.put("address",customerInfo.get("ADDRESS"));
			model.put("cust_no",customerInfo.get("CUST_NO"));
			paramMap.put("cust_no", customerInfo.get("CUST_NO"));
		}
		
		//오른쪽 금일 주문 목록
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getHistoryList(paramMap);
		
		List<Map> resultList = new ArrayList();
		int cnt=0;

		for( Map<String, Object> salesList1 : salesList){
			Map<String,Object> salesDailyList = new HashMap<String, Object>();
			for(Map.Entry<String, Object> entry: salesList1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				salesDailyList.put(key, value);
				if("SALES_NO".equals(key)){
					String menuName;
					menuName = salesService.getSalesDetail(Integer.parseInt(value.toString()));
					
					salesDailyList.put("MENU", menuName.toString());
					
				}
				
			}

			resultList.add(salesDailyList);
			cnt++;
		}
		
		
		model.addAttribute("sales_List",resultList);
		
	}
	
	@RequestMapping("/order/order_sin")
	public void order_sin(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {

		log.info("map : " + paramMap.toString());

		//mod 1은 신화명 2는 물꽁 3은 감자탕
		paramMap.put("mod", "01");
		List menuList = orderService.getMenuList(paramMap);
		List menuNameList = orderService.getMenuName(paramMap);
		model.addAttribute("menuNameList",menuNameList);
		model.addAttribute("menuList",menuList);
		
		String phone = util.print((String)paramMap.get("phone"));
		String address = util.print((String)paramMap.get("address"));
		String cust_no = util.print((String)paramMap.get("cust_no"));
		
		if("".equals(cust_no))
			paramMap.put("cust_no", "0");
		
		//Convert List to Map
		List<Map<String,Object>> userInfo;
		userInfo = orderService.getCustomerInfo(paramMap);
		
		Map<String,Object> customerInfo = new HashMap<String, Object>();
		for( Map<String, Object> customerInfo1 : userInfo){
			for(Map.Entry<String, Object> entry: customerInfo1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				customerInfo.put(key, value);
			}
		}
		
		
		String flag = util.print(customerInfo.get("CUST_NO"));
		
		if("".equals(flag)){
			model.put("phone",phone);
			model.put("address",address);
		}
		else{
			System.out.println("*********************************\n[debug] cust_no : "+customerInfo.get("CUST_NO"));
			model.put("phone",customerInfo.get("PHONE"));
			model.put("address",customerInfo.get("ADDRESS"));
			model.put("cust_no",customerInfo.get("CUST_NO"));
			model.put("cnt",customerInfo.get("CNT"));
			paramMap.put("cust_no", customerInfo.get("CUST_NO"));
		}
		
		//오른쪽 주문 목록
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getHistoryList(paramMap);
		
		List<Map> resultList = new ArrayList();
		int cnt=0;

		for( Map<String, Object> salesList1 : salesList){
			Map<String,Object> salesHistoryList = new HashMap<String, Object>();
			for(Map.Entry<String, Object> entry: salesList1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				salesHistoryList.put(key, value);
				if("SALES_NO".equals(key)){
					String menuName;
					menuName = salesService.getSalesDetail(Integer.parseInt(value.toString()));
					
					salesHistoryList.put("MENU", menuName.toString());
					
				}
				
				if("SECTION".equals(key) && "1".equals(value)){
					salesHistoryList.put("SECTION", "신화명".toString());
				}
				else if("SECTION".equals(key) && "2".equals(value)){
					salesHistoryList.put("SECTION", "물꽁".toString());
				}
				else if("SECTION".equals(key) && "3".equals(value)){
					salesHistoryList.put("SECTION", "청진동".toString());
				}
			}

			resultList.add(salesHistoryList);
			cnt++;
		}
		
		
		model.addAttribute("sales_List",resultList);
		
	}
	
	@RequestMapping("/order/order_mul")
	public void order_mul(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {

		log.info("map : " + paramMap.toString());

		//mod 1은 신화명 2는 물꽁 3은 감자탕
		paramMap.put("mod", "02");
		List menuList = orderService.getMenuList(paramMap);
		List menuNameList = orderService.getMenuName(paramMap);
		model.addAttribute("menuNameList",menuNameList);
		model.addAttribute("menuList",menuList);
		
		String phone = util.print((String)paramMap.get("phone"));
		String address = util.print((String)paramMap.get("address"));
		String cust_no = util.print((String)paramMap.get("cust_no"));
		
		if("".equals(cust_no))
			paramMap.put("cust_no", "0");
		
		//Convert List to Map
		List<Map<String,Object>> userInfo;
		userInfo = orderService.getCustomerInfo(paramMap);
		
		Map<String,Object> customerInfo = new HashMap<String, Object>();
		for( Map<String, Object> customerInfo1 : userInfo){
			for(Map.Entry<String, Object> entry: customerInfo1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				customerInfo.put(key, value);
			}
		}
		
		
		String flag = util.print(customerInfo.get("CUST_NO"));
		
		if("".equals(flag)){
			model.put("phone",phone);
			model.put("address",address);
		}
		else{
			System.out.println("*********************************\n[debug] cust_no : "+customerInfo.get("CUST_NO"));
			model.put("phone",customerInfo.get("PHONE"));
			model.put("address",customerInfo.get("ADDRESS"));
			model.put("cust_no",customerInfo.get("CUST_NO"));
			model.put("cnt",customerInfo.get("CNT"));
			paramMap.put("cust_no", customerInfo.get("CUST_NO"));
		}
		
		//오른쪽 주문 목록
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getHistoryList(paramMap);
		
		List<Map> resultList = new ArrayList();
		int cnt=0;

		for( Map<String, Object> salesList1 : salesList){
			Map<String,Object> salesHistoryList = new HashMap<String, Object>();
			for(Map.Entry<String, Object> entry: salesList1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				salesHistoryList.put(key, value);
				if("SALES_NO".equals(key)){
					String menuName;
					menuName = salesService.getSalesDetail(Integer.parseInt(value.toString()));
					
					salesHistoryList.put("MENU", menuName.toString());
					
				}
				
				if("SECTION".equals(key) && "1".equals(value)){
					salesHistoryList.put("SECTION", "신화명".toString());
				}
				else if("SECTION".equals(key) && "2".equals(value)){
					salesHistoryList.put("SECTION", "물꽁".toString());
				}
				else if("SECTION".equals(key) && "3".equals(value)){
					salesHistoryList.put("SECTION", "청진동".toString());
				}
			}

			resultList.add(salesHistoryList);
			cnt++;
		}
		
		
		model.addAttribute("sales_List",resultList);
		
	}
	

	@RequestMapping("/order/order_chung")
	public void order_chung(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {

		log.info("map : " + paramMap.toString());

		//mod 1은 신화명 2는 물꽁 3은 감자탕
		paramMap.put("mod", "03");
		List menuList = orderService.getMenuList(paramMap);
		List menuNameList = orderService.getMenuName(paramMap);
		model.addAttribute("menuNameList",menuNameList);
		model.addAttribute("menuList",menuList);
		
		String phone = util.print((String)paramMap.get("phone"));
		String address = util.print((String)paramMap.get("address"));
		String cust_no = util.print((String)paramMap.get("cust_no"));
		
		if("".equals(cust_no))
			paramMap.put("cust_no", "0");
		
		//Convert List to Map
		List<Map<String,Object>> userInfo;
		userInfo = orderService.getCustomerInfo(paramMap);
		
		Map<String,Object> customerInfo = new HashMap<String, Object>();
		for( Map<String, Object> customerInfo1 : userInfo){
			for(Map.Entry<String, Object> entry: customerInfo1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				customerInfo.put(key, value);
			}
		}
		
		
		String flag = util.print(customerInfo.get("CUST_NO"));
		
		if("".equals(flag)){
			model.put("phone",phone);
			model.put("address",address);
		}
		else{
			System.out.println("*********************************\n[debug] cust_no : "+customerInfo.get("CUST_NO"));
			model.put("phone",customerInfo.get("PHONE"));
			model.put("address",customerInfo.get("ADDRESS"));
			model.put("cust_no",customerInfo.get("CUST_NO"));
			model.put("cnt",customerInfo.get("CNT"));
			paramMap.put("cust_no", customerInfo.get("CUST_NO"));
		}
		
		//오른쪽 주문 목록
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getHistoryList(paramMap);
		
		List<Map> resultList = new ArrayList();
		int cnt=0;

		for( Map<String, Object> salesList1 : salesList){
			Map<String,Object> salesHistoryList = new HashMap<String, Object>();
			for(Map.Entry<String, Object> entry: salesList1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				salesHistoryList.put(key, value);
				if("SALES_NO".equals(key)){
					String menuName;
					menuName = salesService.getSalesDetail(Integer.parseInt(value.toString()));
					
					salesHistoryList.put("MENU", menuName.toString());
					
				}
				
				if("SECTION".equals(key) && "1".equals(value)){
					salesHistoryList.put("SECTION", "신화명".toString());
				}
				else if("SECTION".equals(key) && "2".equals(value)){
					salesHistoryList.put("SECTION", "물꽁".toString());
				}
				else if("SECTION".equals(key) && "3".equals(value)){
					salesHistoryList.put("SECTION", "청진동".toString());
				}
			}

			resultList.add(salesHistoryList);
			cnt++;
		}
		
		
		model.addAttribute("sales_List",resultList);
		
	}
	
	@RequestMapping("/order/addOrder")
	public ModelAndView addCustomer(@ModelAttribute("addOrder") AddOrder addOrder, @ModelAttribute("addOrderDetail") AddOrderDetail addOrderDetail,@RequestParam Map<String, Object> paramMap , ModelMap model) throws Throwable {
		log.info("addOrder List::::::::::: "+addOrderDetail.getMenu_no());

		String orderListValue = util.print((String)paramMap.get("orderListValue"));
		String[] orderArray = orderListValue.split(",");
		

		String etcListValue = util.print((String)paramMap.get("etcListValue"));
		String[] etcArray = etcListValue.split(",");
		
		int result = orderService.addOrder(addOrder);

		for(int i =0;i<orderArray.length;i++){
			addOrderDetail.setMenu_no(orderArray[i]);
			addOrderDetail.setEtc(etcArray[i]);
			orderService.addOrderDetail(addOrderDetail);
		}
		//뷰화면 redirect
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/comm/main/main.do");
		return mav;
	}
}
