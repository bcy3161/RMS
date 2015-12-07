package com.nara.common.dao;

import java.util.Map;


public interface MainDao {

	public int getTodaySalesCnt(Map<String, Object> paramMap);
	public int getCustomerCnt(Map<String, Object> paramMap);
}
