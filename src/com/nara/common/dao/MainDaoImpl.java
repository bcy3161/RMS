package com.nara.common.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MainDaoImpl extends SqlSessionDaoSupport implements MainDao {

	/**
	 *  get today's Sales count for main summary
	 * */
	public int getTodaySalesCnt(Map<String, Object> paramMap){
		int cnt = getSqlSession().selectOne("main.getTodaySalesCnt",paramMap);
		return cnt;
	}
	
	/**
	 *  get sum sales in this month
	 * */
	public String getSalesSum(Map<String, Object> paramMap){
		String sum = getSqlSession().selectOne("main.getSalesSum",paramMap);
		return sum;
	}
	
	/**
	 * get Customer count for main summary
	 * */
	public int getCustomerCnt(Map<String, Object> paramMap){
		int cnt = getSqlSession().selectOne("main.getCustomerCnt",paramMap);
		return cnt;
	}

	/**
	 * get today Sales List
	 * */
	public List getTodaySalesList(Map<String, Object> paramMap){
		List cnt = getSqlSession().selectList("main.getTodaySalesList",paramMap);
		return cnt;
	}
	

	public String getSalesDetail(int sales_no){
		String ret = getSqlSession().selectOne("sales.getSalesDetail", sales_no);
		
		return ret;
	}
}


