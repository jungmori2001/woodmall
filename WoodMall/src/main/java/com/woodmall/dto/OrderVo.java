package com.woodmall.dto;

import java.sql.Date;

public class OrderVo {
	private int orderNum;	//시퀀스
	private int prodNum;	
	private String userId;
//	private String name;
	private int orderQuan;	// 1 고정
	private String paymentStatus;	// 결제정보
	private int price;
	private Date orderDate;	// default sysDate 
	private String orderContent;	// 주문사항 현재 null
	private String orderStatus;		// 주문상태 

	@Override
	public String toString() {
		return "OrderVo [ordernum=" + orderNum + ", prodnum=" + prodNum +", userid="+userId+"," + ", orderquen=" + orderQuan + ", paymentstatus=" + paymentStatus
				+ ", price=" + price + ",orderdate=" + orderDate +", ordercontent=" + orderContent +", orderstatus=" + orderStatus + "]";
		}
	

	
	
	
public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}





public int getProdNum() {
	return prodNum;
	}
	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
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


	public int getOrderQuan() {
		return orderQuan;
	}


	public void setOrderQuan(int orderQuan) {
		this.orderQuan = orderQuan;
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