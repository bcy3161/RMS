package com.nara.order.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.nara.order.vo.AddOrder;

public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao {
	
	/**
	 * get Menu List for option
	 * */
	public List getMenuList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("order.getMenuList", paramMap);
		
		return ret;
	}
	
	/**
	 * get Customer Infomation
	 * */
	public List getCustomerInfo(Map<String, Object> paramMap){
		//List ret = getSqlSession().selectList("order.getCustomerInfo", paramMap);
		List ret = getSqlSession().selectList("order.getCustomerInfo", paramMap);
		
		return ret;
	}
	
	/**
	 * Add Order
	 * */
	public int addOrder(AddOrder addOrder){
		int ret = 0;
		
		ret = getSqlSession().insert("order.addNewOrder",addOrder);
		
		return ret;
	}
}


