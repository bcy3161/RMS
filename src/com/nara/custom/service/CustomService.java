package com.nara.custom.service;

import java.util.List;
import java.util.Map;

import com.nara.custom.dao.CustomDao;
import com.nara.custom.vo.AddCustom;


public interface CustomService {
	
	public void setCustomDao(CustomDao customDao);
	
	public List getAllCustomerList(Map<String, Object> paramMap);

	public int addCustomer(AddCustom addCustom);
}
