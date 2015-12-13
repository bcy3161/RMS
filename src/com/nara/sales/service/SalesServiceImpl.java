package com.nara.sales.service;

import java.util.List;
import java.util.Map;

import com.nara.common.dao.MainDao;
import com.nara.order.dao.OrderDao;
import com.nara.sales.dao.SalesDao;

public class SalesServiceImpl implements SalesService {
	

	private SalesDao salesDao;


	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}
	
	/**
	 * get Daily Sales List
	 * */
	public List getDailyList(Map<String, Object> paramMap){
		List ret = salesDao.getDailyList(paramMap);
		
		return ret;
	}
	
	/**
	 * get Monthly Sales List
	 * */
	public List getMonthlyList(Map<String, Object> paramMap){
		List ret = salesDao.getMonthlyList(paramMap);
		
		return ret;
	}

	/**
	 * get Between Sales List
	 * */
	public List getBetweenList(Map<String, Object> paramMap){
		List ret = salesDao.getBetweenList(paramMap);
		
		return ret;
	}
	
	public String getSalesDetail(int sales_no){
		String ret = salesDao.getSalesDetail(sales_no);
		
		return ret;
	}

	/**
	 * get History List about customer
	 * */
	public List getHistoryList(Map<String, Object> paramMap){
		List ret = salesDao.getHistoryList(paramMap);
		
		return ret;
	}
	
}
