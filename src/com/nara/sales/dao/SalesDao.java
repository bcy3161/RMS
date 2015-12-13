package com.nara.sales.dao;

import java.util.List;
import java.util.Map;


public interface SalesDao {

	public List getDailyList(Map<String, Object> paramMap);
	
	public List getMonthlyList(Map<String, Object> paramMap);

	public List getBetweenList(Map<String, Object> paramMap);
	
	public String getSalesDetail(int sales_no);

	public List getHistoryList(Map<String, Object> paramMap);
}
