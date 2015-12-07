package com.nara.order.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao {
	
	/**
	 * get Menu List for option
	 * */
	public List getMenuList(Map<String, Object> paramMap){
		List ret = getSqlSession().selectList("order.getMenuList", paramMap);
		
		return ret;
	}
	
}


