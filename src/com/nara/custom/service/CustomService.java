package com.nara.custom.service;

import java.util.List;
import java.util.Map;

import com.nara.custom.dao.CustomDao;


public interface CustomService {
	
	public void setCustomDao(CustomDao customDao);
	
	public List getAllCustomerList(Map<String, Object> paramMap);
}
