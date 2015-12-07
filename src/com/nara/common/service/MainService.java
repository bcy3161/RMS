package com.nara.common.service;


import java.util.Map;

import com.nara.common.dao.MainDao;


public interface MainService {
	
	public void setMainDao(MainDao mainDao);

	public int getTodaySalesCnt(Map<String, Object> paramMap);
	
	public int getCustomerCnt(Map<String, Object> paramMap);
	
}
