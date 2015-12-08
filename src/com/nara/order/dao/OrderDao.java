package com.nara.order.dao;

import java.util.List;
import java.util.Map;


public interface OrderDao {
	
	public List getMenuList(Map<String, Object> paramMap);

	public List getCustomerInfo(Map<String, Object> paramMap);
}
