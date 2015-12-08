package com.nara.order.vo;

import java.util.Date;

public class AddOrder{
	
	int sales_no;
	String cust_no;
	String menu;
	String cost_sum;
	Date sales_date;
	String pay;
	public int getSales_no() {
		return sales_no;
	}
	public void setSales_no(int sales_no) {
		this.sales_no = sales_no;
	}
	public String getCust_no() {
		return cust_no;
	}
	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getCost_sum() {
		return cost_sum;
	}
	public void setCost_sum(String cost_sum) {
		this.cost_sum = cost_sum;
	}
	public Date getSales_date() {
		return sales_date;
	}
	public void setSales_date(Date sales_date) {
		this.sales_date = sales_date;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	
	
}