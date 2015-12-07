package com.nara.sales.service;

import java.util.List;
import java.util.Map;

import com.nara.common.dao.MainDao;
import com.nara.order.dao.OrderDao;
import com.nara.sales.dao.SalesDao;

public class SalesServiceImpl implements SalesService {
	

	private SalesDao salesDao;


	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}

}
