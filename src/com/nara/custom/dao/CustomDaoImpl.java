package com.nara.custom.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.nara.custom.vo.AddCustom;

public class CustomDaoImpl extends SqlSessionDaoSupport implements CustomDao {
	
	/**
	 * get Customer List for management customer
	 * */
	public List getAllCustomerList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("custom.getAllCustomerList", paramMap);
		
		return ret;
	}
	
	/**
	 * add New Customer
	 * */
	public int addCustomer(AddCustom addCustom){
		int ret = 0;
		
		ret = getSqlSession().insert("custom.addNewCustomer",addCustom);
		
		return ret;
	}
}


