package com.nara.common;

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


@Controller
@RequestMapping("/comm")
public class CommonController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping("/main/main")
	public void main(@RequestParam Map<String, Object> paramMap, ModelMap model, Principal principal) throws Throwable {
		
		// 메뉴 번호 세팅
		String menu_id = SoftUtil.print((String)paramMap.get("menu_id"));
		// 메뉴 번호 없으면 1세팅
		if("".equals(menu_id)) menu_id = "0";
		
		model.addAttribute("menu_id", menu_id);
		
	}
	
}
