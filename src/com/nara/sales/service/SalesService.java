package com.nara.sales.service;

import java.util.List;
import java.util.Map;

import com.nara.custom.vo.AddCustom;
import com.nara.order.vo.AddOrder;
import com.nara.sales.dao.SalesDao;


public interface SalesService {

	public void setSalesDao(SalesDao salesDao);
	public List getDailyList(Map<String, Object> paramMap);
	public List getMonthlyList(Map<String, Object> paramMap);
	public int addOrder(AddOrder addOrder);
}
