package com.nara.sales;

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
		System.out.println("****************************************************************\n[debug] sdate : " + sdate+"\n[debug] paramMap : "+(String)paramMap.get("sdate"));
		paramMap.put("sdate", sdate);
		
		
		List salesList = salesService.getDailyList(paramMap);
		model.addAttribute("salesList",salesList);
		model.put("sdate", sdate);
	}

	@RequestMapping("/salesMonthly/salesMonthly")
	public void salesMonthly(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		String sdate = util.print((String)paramMap.get("sdate"));
		System.out.println("****************************************************************\n[debug] sdate : " + sdate+"\n[debug] paramMap : "+(String)paramMap.get("sdate"));
		paramMap.put("sdate", sdate);
		
		
		List salesList = salesService.getMonthlyList(paramMap);
		model.addAttribute("salesList",salesList);
		model.put("sdate", sdate);
		
	}
}
