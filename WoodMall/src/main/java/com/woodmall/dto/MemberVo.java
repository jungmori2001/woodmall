package com.woodmall.dto;

public class MemberVo {
	
	/*
	 * name VARCHAR(10), userid VARCHAR(10), password VARCHAR(20), emailId
	 * VARCHAR(10), emailAddress VARCHAR(15), PhoneNum VARCHAR(5), postNum
	 * VARCHAR(6), mainAddress VARCHAR(20), detailAddress VARCHAR(20), subAddress
	 * VARCHAR(20), grade VARCHAR(20), admin NUMBER(1), totalPurchase NUMBER,
	 */
	
	private String name;
	private String userid;
	private String password;
	private String PhoneNum;
	private String emailAddress;
	private String postNum;
	private String mainAddress;
	private String detailAddress;
	private String subAddress;
	
	
	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", userid=" + userid + ", password=" + password + ", PhoneNum=" + PhoneNum
				+ ", emailAddress=" + emailAddress + ", postNum=" + postNum + ", mainAddress=" + mainAddress
				+ ", detailAddress=" + detailAddress + ", subAddress=" + subAddress + "]";
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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





}
	






