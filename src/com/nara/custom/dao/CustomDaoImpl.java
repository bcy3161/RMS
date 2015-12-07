package com.nara.custom.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CustomDaoImpl extends SqlSessionDaoSupport implements CustomDao {
	

	public List getAllCustomerList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("custom.getAllCustomerList", paramMap);
		
		return ret;
	}
}


