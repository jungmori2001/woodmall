package com.woodmall.dto;

public class MemberVo {
	
	/*
	 * name VARCHAR(10), userid VARCHAR(10), password VARCHAR(20), emailId
	 * VARCHAR(10), emailAddress VARCHAR(15), PhoneNum VARCHAR(5), postNum
	 * VARCHAR(6), mainAddress VARCHAR(20), detailAddress VARCHAR(20), subAddress
	 * VARCHAR(20), grade VARCHAR(20), admin NUMBER(1), totalPurchase NUMBER,
	 */
	
	private String name;
	private String userId;
	private String password;
	private String emailId;
	private String emailAddress;
	private String firstPhone;
	private String midPhone;
	private String lastPhone;
	private String postNum;
	private String mainAddress;
	private String detailAddress;
	private String subAddress;
	private String grade;
	private int admin;
	private int totalPurchase;
	
//	@Override
//	public String toString() {
//		return "MemberVo [name=" + name + ", userid=" + userid + ", password=" + password + ", emailId=" + emailId
//				+ ", emailAddress=" + emailAddress + ", firstPhone=" + firstPhone + ", midPhone=" + midPhone
//				+ ", lastPhone=" + lastPhone + ", postNum=" + postNum + ", mainAddress=" + mainAddress
//				+ ", detailAddress=" + detailAddress + ", subAddress=" + subAddress + ", grade=" + grade + ", admin="
//				+ admin + ", totalPurchase=" + totalPurchase + ", getName()=" + getName() + ", getUserid()="
//				+ getUserid() + ", getPassword()=" + getPassword() + ", getEmailAddress()=" + getEmailAddress()
//				+ ", getFirstPhone()=" + getFirstPhone() + ", getMidPhone()=" + getMidPhone() + ", getLastPhone()="
//				+ getLastPhone() + ", getPostNum()=" + getPostNum() + ", getMainAddress()=" + getMainAddress()
//				+ ", getDetailAddress()=" + getDetailAddress() + ", getSubAddress()=" + getSubAddress()
//				+ ", getEmailId()=" + getEmailId() + ", getGrade()=" + getGrade() + ", getAdmin()=" + getAdmin()
//				+ ", getTotalPurchase()=" + getTotalPurchase() + ", getClass()=" + getClass() + ", hashCode()="
//				+ hashCode() + ", toString()=" + super.toString() + "]";
//	}
	
	
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getTotalPurchase() {
		return totalPurchase;
	}
	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}
	
	@Override
	public String toString() {
		return "MemberVo [name=" + name + ", userid=" + userId + ", password=" + password + ", emailId=" + emailId
				+ ", emailAddress=" + emailAddress + ", firstPhone=" + firstPhone + ", midPhone=" + midPhone
				+ ", lastPhone=" + lastPhone + ", postNum=" + postNum + ", mainAddress=" + mainAddress
				+ ", detailAddress=" + detailAddress + ", subAddress=" + subAddress + ", grade=" + grade + ", admin="
				+ admin + ", totalPurchase=" + totalPurchase + "]";
	}







}
	






