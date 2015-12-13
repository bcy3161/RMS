package com.nara.custom;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nara.custom.service.CustomService;
import com.nara.custom.vo.AddCustom;
import com.nara.framework.util.SoftUtil;
import com.nara.order.service.OrderService;
import com.nara.sales.service.SalesService;


@Controller
@RequestMapping("/custom")
public class CustomController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomController.class);
	private static SoftUtil util = new SoftUtil();
	
	@Autowired
	private CustomService customService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private OrderService orderService;
	
	
	
	@RequestMapping("/custom/customer")
	public void customer(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		List ret = customService.getAllCustomerList(paramMap);
		model.addAttribute("result",ret);
		
	}

	@RequestMapping("/customInfo/popUpInfo")
	public void popUpInfo(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());

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
		model.put("cnt",customerInfo.get("CNT"));
		
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
	
	@RequestMapping("/custom/addCustomerView")
	public void addCustomerView(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		String phone = util.print((String)paramMap.get("phone"));
		String address = util.print((String)paramMap.get("address"));
		model.put("phone", phone);
		
	}
	
	@RequestMapping("/custom/addCustomer")
	public ModelAndView addCustomer(@ModelAttribute("addCustom") AddCustom addCustom, ModelMap model) throws Throwable {
		log.info("addCustom List:::::::::::" + addCustom.getCust_no()+", " + addCustom.getAddress() + ", "+ addCustom.getPhone());
		
		int result = customService.addCustomer(addCustom);
		
		//뷰화면 redirect
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/custom/custom/addCustomerView.do");
		return mav;
	}
	
}
