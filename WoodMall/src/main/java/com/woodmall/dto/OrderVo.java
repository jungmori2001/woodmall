package com.woodmall.dto;

import java.sql.Date;

public class OrderVo {
	private int orderNum;
	private String name;
	private int orderQuen;
	private String paymentStatus;
	private int price;
	private Date orderDate;
	private String orderContent;
	private String orderStatus;

	@Override
	public String toString() {
		return "OrderVo [ordernum=" + orderNum + ", name=" + name + ", orderquen=" + orderQuen + ", paymentstatus=" + paymentStatus
				+ ", price=" + price + ",orderdate=" + orderDate + ", ordercontent=" + orderContent +", orderstatus" + orderStatus + "]";
		}
public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getOrderQuen() {
		return orderQuen;
	}


	public void setOrderQuen(int orderQuen) {
		this.orderQuen = orderQuen;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderContent() {
		return orderContent;
	}


	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


}