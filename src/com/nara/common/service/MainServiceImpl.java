package com.nara.common.service;

import java.util.Map;

import com.nara.common.dao.MainDao;

public class MainServiceImpl implements MainService {
	

	private MainDao mainDao;


	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	/**
	 * get toDay's Sales count for main summary
	 * */
	public int getTodaySalesCnt(Map<String, Object> paramMap){
		int ret = mainDao.getTodaySalesCnt(paramMap);
		
		return ret;
	}
	
	/**
	 * get Customer count for main summary
	 * */
	public int getCustomerCnt(Map<String, Object> paramMap){
		int ret = mainDao.getCustomerCnt(paramMap);
		
		return ret;
	}
}
