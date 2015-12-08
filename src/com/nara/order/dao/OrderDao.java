package com.nara.order.dao;

import java.util.List;
import java.util.Map;

import com.nara.order.vo.AddOrder;


public interface OrderDao {
	
	public List getMenuList(Map<String, Object> paramMap);

	public List getCustomerInfo(Map<String, Object> paramMap);

	public int addOrder(AddOrder addOrder);
}
