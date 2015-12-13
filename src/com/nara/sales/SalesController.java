package com.nara.sales;

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
import com.nara.order.service.OrderService;
import com.nara.sales.service.SalesService;


@Controller
@RequestMapping("/sales")
public class SalesController {
	
	private static final Logger log = LoggerFactory.getLogger(SalesController.class);
	private static SoftUtil util = new SoftUtil();
	
	@Autowired
	private SalesService salesService;
	
	
	@RequestMapping("/salesDaily/salesDaily")
	public void salesDaily(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		String sdate = util.print((String)paramMap.get("sdate"));
		String pay = util.print((String)paramMap.get("pay"));
		paramMap.put("sdate", sdate);
		paramMap.put("pay", pay);
		
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getDailyList(paramMap);
		
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
		
		
		model.addAttribute("salesList",resultList);
		model.put("sdate", sdate);
	}
	

	@RequestMapping("/salesBetween/salesBetween")
	public void salesBetween(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		String sdate = util.print((String)paramMap.get("sdate"));
		String edate = util.print((String)paramMap.get("edate"));
		String pay = util.print((String)paramMap.get("pay"));
		paramMap.put("sdate", sdate);
		paramMap.put("edate", edate);
		paramMap.put("pay", pay);
		
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getBetweenList(paramMap);
		
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
		
		
		model.addAttribute("salesList",resultList);
	}

	@RequestMapping("/salesMonthly/salesMonthly")
	public void salesMonthly(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		String sdate = util.print((String)paramMap.get("sdate"));
		paramMap.put("sdate", sdate);
		
		
		//List salesList = salesService.getMonthlyList(paramMap);
		//Convert List to Map
		List<Map<String,Object>> salesList;
		salesList = salesService.getMonthlyList(paramMap);
		
		List<Map> resultList = new ArrayList();
		int cnt=0;

		for( Map<String, Object> salesList1 : salesList){
			Map<String,Object> salesMonthlyList = new HashMap<String, Object>();
			for(Map.Entry<String, Object> entry: salesList1.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				salesMonthlyList.put(key, value);
				if("SALES_NO".equals(key)){
					String menuName;
					menuName = salesService.getSalesDetail(Integer.parseInt(value.toString()));
					
					salesMonthlyList.put("MENU", menuName.toString());
					
				}
				
			}

			resultList.add(salesMonthlyList);
			cnt++;
		}
		
		
		model.addAttribute("salesList",resultList);
		model.put("sdate", sdate);
		
	}
}
