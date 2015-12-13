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

	/**
	 * get Between Sales List
	 * */
	public List getBetweenList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("sales.getBetweenList", paramMap);
		
		return ret;
	}

	public String getSalesDetail(int sales_no){
		String ret = getSqlSession().selectOne("sales.getSalesDetail", sales_no);
		
		return ret;
	}
	
	/**
	 * get History about customer
	 * */
	public List getHistoryList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("sales.getHistoryList", paramMap);
		
		return ret;
	}
}


