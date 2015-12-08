package com.nara.common;

import java.security.Principal;
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


@Controller
@RequestMapping("/comm")
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping("/main/main")
	public void main(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());

		int today_cnt = mainService.getTodaySalesCnt(paramMap);
		int sales_sum = mainService.getSalesSum(paramMap);
		int cust_cnt = mainService.getCustomerCnt(paramMap);
		List today_list = mainService.getTodaySalesList(paramMap);
		
		if("".equals(today_cnt)){
			today_cnt=0;
		}
		if("".equals(sales_sum)){
			sales_sum=0;
		}
		if("".equals(cust_cnt)){
			cust_cnt=0;
		}
		
		model.put("today_cnt", today_cnt);
		model.put("sales_sum", sales_sum);
		model.put("cust_cnt", cust_cnt);
		model.addAttribute("today_list", today_list);
	}
	
}
