package com.nara.common;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nara.common.service.MainService;
import com.nara.framework.util.SoftUtil;
import com.nara.sales.service.SalesService;


@Controller
@RequestMapping("/comm")
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private MainService mainService;
	@Autowired
	private SalesService salesService;
	
	
	@RequestMapping("/main/main")
	public void main(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		paramMap.put("mod", 1);
		String sales_sum_1 = mainService.getSalesSum(paramMap);
		paramMap.put("mod", 2);
		String sales_sum_2 = mainService.getSalesSum(paramMap);
		paramMap.put("mod", 3);
		String sales_sum_3 = mainService.getSalesSum(paramMap);
		int cust_cnt = mainService.getCustomerCnt(paramMap);
		
		//오른쪽 금일 주문 목록
		//Convert List to Map
		List<Map<String,Object>> today_list;
		today_list = mainService.getTodaySalesList(paramMap);
		
		List<Map> resultList = new ArrayList();
		int cnt=0;

		for( Map<String, Object> salesList1 : today_list){
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
		
		model.addAttribute("today_list",resultList);
		if("".equals(cust_cnt)){
			cust_cnt=0;
		}
		
		model.put("sales_sum_1", sales_sum_1);
		model.put("sales_sum_2", sales_sum_2);
		model.put("sales_sum_3", sales_sum_3);
		model.put("cust_cnt", cust_cnt);
	}
	
}
