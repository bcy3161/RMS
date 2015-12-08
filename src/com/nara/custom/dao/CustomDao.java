package com.nara.custom.dao;

import java.util.List;
import java.util.Map;

import com.nara.custom.vo.AddCustom;


public interface CustomDao {

	public List getAllCustomerList(Map<String, Object> paramMap);
	
	public int addCustomer(AddCustom addCustom);
}
