package com.nara.order.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.nara.order.vo.AddOrder;
import com.nara.order.vo.AddOrderDetail;

public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao {
	
	/**
	 * get Menu List for option
	 * */
	public List getMenuList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("order.getMenuList", paramMap);
		
		return ret;
	}
	
	public List getMenuName(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("order.getMenuName", paramMap);
		
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
		int ret = 0, ret2 = 0;
		
		ret = getSqlSession().insert("order.addNewOrder",addOrder);

		ret2 = getSqlSession().insert("order.updateCustomerCnt",addOrder);
		return ret;
	}

	public int addOrderDetail(AddOrderDetail addOrderDetail){
		int ret = 0;
		
		ret = getSqlSession().insert("order.addNewOrderDetail",addOrderDetail);
		
		return ret;
	}
}

