package com.nara.order.vo;


public class AddOrderDetail{
	
	
	int sales_no;
	String menu_no;
	String etc;
	int getSales_no() {
		return sales_no;
	}
	public void setSales_no(int sales_no) {
		this.sales_no = sales_no;
	}
	public String getMenu_no() {
		return menu_no;
	}
	public void setMenu_no(String menu_no) {
		this.menu_no = menu_no;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}
}