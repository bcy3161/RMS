package com.nara.order.service;

import java.util.List;
import java.util.Map;

import com.nara.common.dao.MainDao;
import com.nara.order.dao.OrderDao;

public class OrderServiceImpl implements OrderService {
	

	private OrderDao orderDao;


	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * get Menu List for option
	 * */
	public List getMenuList(Map<String, Object> paramMap){
		List ret = orderDao.getMenuList(paramMap);
		
		return ret;
	}
	
}
