package com.nara.order;

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


@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	private static SoftUtil util = new SoftUtil();
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping("/order/order")
	public void order(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {

		log.info("map : " + paramMap.toString());
		
		List menuList = orderService.getMenuList(paramMap);
		model.addAttribute("menuList",menuList);
		
		String phone = util.print((String)paramMap.get("phone"));
		String address = util.print((String)paramMap.get("address"));
		
		//오른쪽 금일 주문 목록
		List today_list = mainService.getTodaySalesList(paramMap);
		model.addAttribute("today_list", today_list);
		
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
		}
		
	}
	
	@RequestMapping("/order/addOrder")
	public ModelAndView addCustomer(@ModelAttribute("addOrder") AddOrder addOrder, ModelMap model) throws Throwable {
		log.info("addOrder List:::::::::::" + addOrder.getSales_no()+", "+addOrder.getCust_no()+", " + addOrder.getCost_sum() + ", "+ addOrder.getMenu());
		
		int result = orderService.addOrder(addOrder);
		
		//뷰화면 redirect
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/order/order/order.do");
		return mav;
	}
}
