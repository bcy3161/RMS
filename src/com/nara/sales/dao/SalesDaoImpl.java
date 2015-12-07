package com.nara.sales.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class SalesDaoImpl extends SqlSessionDaoSupport implements SalesDao {
	
	public String getUserPwd(String userid) {
		return (String)getSqlSession().selectOne("main.getUserPwd",userid);
	}
	
}


