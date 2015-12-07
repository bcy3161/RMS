package com.nara.common.dao;

import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MainDaoImpl extends SqlSessionDaoSupport implements MainDao {

	/**
	 *  get toDay's Sales count for main summary
	 * */
	public int getTodaySalesCnt(Map<String, Object> paramMap){
		int cnt = getSqlSession().selectOne("main.getTodaySalesCnt",paramMap);
		return cnt;
	}
	/**
	 * get Customer count for main summary
	 * */
	public int getCustomerCnt(Map<String, Object> paramMap){
		int cnt = getSqlSession().selectOne("main.getCustomerCnt",paramMap);
		return cnt;
	}
	
}


