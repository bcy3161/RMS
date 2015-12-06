package com.nara.common.service;

import java.util.List;
import java.util.Map;


public interface MainService {

	public String getToday();
	
	public int writeProc(Map<String, Object> paramMap);
	
	//public int writeProc2(Board board);
	
	public List getList(Map<String, Object> paramMap);
}
