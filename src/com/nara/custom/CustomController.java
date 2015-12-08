package com.nara.custom;

import java.security.Principal;
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


@Controller
@RequestMapping("/custom")
public class CustomController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomController.class);
	private static SoftUtil util = new SoftUtil();
	
	@Autowired
	private CustomService customService;
	
	
	@RequestMapping("/custom/customer")
	public void customer(@RequestParam Map<String, Object> paramMap, ModelMap model) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		List ret = customService.getAllCustomerList(paramMap);
		model.addAttribute("result",ret);
		
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
