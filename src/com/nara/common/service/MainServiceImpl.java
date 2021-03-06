package com.nara.common.service;

import java.util.List;
import java.util.Map;

import com.nara.common.dao.MainDao;
import com.nara.sales.dao.SalesDao;

public class MainServiceImpl implements MainService {
	

	private MainDao mainDao;
	private SalesDao salesDao;


	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	/**
	 * get today's Sales count for main summary
	 * */
	public int getTodaySalesCnt(Map<String, Object> paramMap){
		int ret = mainDao.getTodaySalesCnt(paramMap);
		
		return ret;
	}

	/**
	 * get sum sales in this month
	 * */
	public String getSalesSum(Map<String, Object> paramMap){
		String ret = mainDao.getSalesSum(paramMap);
		
		return ret;
	}
	
	/**
	 * get Customer count for main summary
	 * */
	public int getCustomerCnt(Map<String, Object> paramMap){
		int ret = mainDao.getCustomerCnt(paramMap);
		
		return ret;
	}

	/**
	 * get today Sales List
	 * */
	public List getTodaySalesList(Map<String, Object> paramMap){
		List ret = mainDao.getTodaySalesList(paramMap);
		
		return ret;
	}
	

	public String getSalesDetail(int sales_no){
		String ret = salesDao.getSalesDetail(sales_no);
		
		return ret;
	}
}
