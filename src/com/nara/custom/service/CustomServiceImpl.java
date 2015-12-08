package com.nara.custom.service;

import java.util.List;
import java.util.Map;

import com.nara.custom.dao.CustomDao;
import com.nara.custom.vo.AddCustom;

public class CustomServiceImpl implements CustomService {
	

	private CustomDao customDao;


	public void setCustomDao(CustomDao customDao) {
		this.customDao = customDao;
	}

	/**
	 * get Customer List for management customer
	 * */
	public List getAllCustomerList(Map<String, Object> paramMap){
		List ret = customDao.getAllCustomerList(paramMap);
		
		return ret;
	}

	/**
	 * add New Customer
	 * */
	public int addCustomer(AddCustom addCustom){
		return customDao.addCustomer(addCustom);
	}
	
}
