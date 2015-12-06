package com.nara.common.service;

import java.util.List;
import java.util.Map;

import com.nara.common.dao.MainDao;

public class MainServiceImpl implements MainService {
	

	private MainDao mainDao;


	public void setMainDao(MainDao mainDao) {
		this.mainDao = mainDao;
	}

	
	public String getToday() {
//		return mainDao.getToday();
		return null;
	}
	
	public int writeProc(Map<String, Object> paramMap) {
//		return mainDao.writeProc(paramMap);
		return 0;
	}
	
	public List getList(Map<String, Object> paramMap) {
//		return mainDao.getList(paramMap);
		return null;
	}
}
