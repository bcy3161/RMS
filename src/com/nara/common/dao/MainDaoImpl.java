package com.nara.common.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MainDaoImpl extends SqlSessionDaoSupport implements MainDao {
	
	public String getUserPwd(String userid) {
		return (String)getSqlSession().selectOne("main.getUserPwd",userid);
	}
	
}


