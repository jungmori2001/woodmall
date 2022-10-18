package com.woodmall.dto;

import java.sql.Date;

public class OrderDetailVo {
	private String prodName;
	private int orderNum;
	private String name;
	private String userId;
	private int orderQuen;
	private String paymentStatus;
	private int price;
	private Date orderDate;
	private String orderContent;
	private String orderStatus;
	private String emailId;
	private String emailAddress;
	private String firstPhone;
	private String midPhone;
	private String lastPhone;
	private String postNum;
	private String mainAddress;
	private String detailAddress;
	private String subAddress;
	
	
	
	@Override
	public String toString() {
		return "OrderDetailVo [prodname =" + prodName +", ordernum=" + orderNum+", name =" + name +",userid="+ userId +", orderquen=" + orderQuen + " paymentstatus="+ paymentStatus
				+ ", price=" + price + ", orderdate=" + orderDate+", + ordercontent="+orderContent+", orderstatus=" + orderStatus 
				+", emailid="+emailId+", emailaddress="+emailAddress+",firstphone="+firstPhone+",midphone="+midPhone+",lastphone="+lastPhone
				+", postnum="+postNum+", mainaddress="+mainAddress+", detailaddress="+detailAddress+",subaddress="+subAddress+"]";
	}

	
	
	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getEmailAddress() {
		return emailAddress;
	}



	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}



	public String getFirstPhone() {
		return firstPhone;
	}



	public void setFirstPhone(String firstPhone) {
		this.firstPhone = firstPhone;
	}



	public String getMidPhone() {
		return midPhone;
	}



	public void setMidPhone(String midPhone) {
		this.midPhone = midPhone;
	}



	public String getLastPhone() {
		return lastPhone;
	}



	public void setLastPhone(String lastPhone) {
		this.lastPhone = lastPhone;
	}



	public String getPostNum() {
		return postNum;
	}



	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}



	public String getMainAddress() {
		return mainAddress;
	}



	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}



	public String getDetailAddress() {
		return detailAddress;
	}



	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}



	public String getSubAddress() {
		return subAddress;
	}



	public void setSubAddress(String subAddress) {
		this.subAddress = subAddress;
	}



	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
