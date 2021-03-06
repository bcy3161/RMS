package com.nara.order.service;

import java.util.List;
import java.util.Map;

import com.nara.order.dao.OrderDao;
import com.nara.order.vo.AddOrder;
import com.nara.order.vo.AddOrderDetail;


public interface OrderService {
	
	public void setOrderDao(OrderDao orderDao);
	
	public List getMenuList(Map<String, Object> paramMap);

	public List getMenuName(Map<String, Object> paramMap);

	public List getCustomerInfo(Map<String, Object> paramMap);

	public int addOrder(AddOrder addOrder);

	public int addOrderDetail(AddOrderDetail addOrderDetail);
}
