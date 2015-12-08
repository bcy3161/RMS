package com.nara.order.service;

import java.util.List;
import java.util.Map;

import com.nara.order.dao.OrderDao;


public interface OrderService {
	
	public void setOrderDao(OrderDao orderDao);
	
	public List getMenuList(Map<String, Object> paramMap);

	public List getCustomerInfo(Map<String, Object> paramMap);
}
