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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nara.custom.service.CustomService;
import com.nara.framework.util.SoftUtil;


@Controller
@RequestMapping("/custom")
public class CustomController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomController.class);
	
	@Autowired
	private CustomService customService;
	
	
	@RequestMapping("/custom/customer")
	public void customer(@RequestParam Map<String, Object> paramMap, ModelMap model, Principal principal) throws Throwable {
		
		log.info("map : " + paramMap.toString());
		
		List ret = customService.getAllCustomerList(paramMap);
		model.addAttribute("result",ret);
		
	}

}
