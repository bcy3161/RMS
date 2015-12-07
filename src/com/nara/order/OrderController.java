package com.nara.order;

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


@Controller
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping("/order/order")
	public void order(@RequestParam Map<String, Object> paramMap, ModelMap model, Principal principal) throws Throwable {

		log.info("map : " + paramMap.toString());
		
		List menuList = orderService.getMenuList(paramMap);
		model.addAttribute("menuList",menuList);
		
	}
	
}
