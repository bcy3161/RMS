package com.nara.custom.service;

import java.util.List;
import java.util.Map;

import com.nara.custom.dao.CustomDao;

public class CustomServiceImpl implements CustomService {
	

	private CustomDao customDao;


	public void setCustomDao(CustomDao customDao) {
		this.customDao = customDao;
	}


	public List getAllCustomerList(Map<String, Object> paramMap){
		List ret = customDao.getAllCustomerList(paramMap);
		
		return ret;
	}
}
