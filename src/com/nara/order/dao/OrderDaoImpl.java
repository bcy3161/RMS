package com.nara.order.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class OrderDaoImpl extends SqlSessionDaoSupport implements OrderDao {
	
	public String getUserPwd(String userid) {
		return (String)getSqlSession().selectOne("main.getUserPwd",userid);
	}
	
}


