package com.nara.sales;

import java.security.Principal;
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
	
	@Autowired
	private SalesService salesService;
	
	
	@RequestMapping("/salesDaily/salesDaily")
	public void salesDaily(@RequestParam Map<String, Object> paramMap, ModelMap model, Principal principal) throws Throwable {
		
		// 메뉴 번호 세팅
		String menu_id = SoftUtil.print((String)paramMap.get("menu_id"));
		// 메뉴 번호 없으면 1세팅
		if("".equals(menu_id)) menu_id = "0";
		
		model.addAttribute("menu_id", menu_id);
		
	}

	@RequestMapping("/salesMonthly/salesMonthly")
	public void salesMonthly(@RequestParam Map<String, Object> paramMap, ModelMap model, Principal principal) throws Throwable {
		
		// 메뉴 번호 세팅
		String menu_id = SoftUtil.print((String)paramMap.get("menu_id"));
		// 메뉴 번호 없으면 1세팅
		if("".equals(menu_id)) menu_id = "0";
		
		model.addAttribute("menu_id", menu_id);
		
	}
}
