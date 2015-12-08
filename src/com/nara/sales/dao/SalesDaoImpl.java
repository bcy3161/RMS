package com.nara.sales.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SalesDaoImpl extends SqlSessionDaoSupport implements SalesDao {
	
	/**
	 * get Daily Sales List
	 * */
	public List getDailyList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("sales.getDailyList", paramMap);
		
		return ret;
	}
	
	/**
	 * get Monthly Sales List
	 * */
	public List getMonthlyList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("sales.getMonthlyList", paramMap);
		
		return ret;
	}
}


