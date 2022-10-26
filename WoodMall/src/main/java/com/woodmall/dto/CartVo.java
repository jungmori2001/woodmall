package com.woodmall.dto;

public class CartVo {
	private	String userId;		// 유저아이디
	private int prodNum;		// 상품코드
	private String prodName;	// 상품명
	private int price;			// 가격
	private int quantity;		// 수량
	private String image;		// 상품 이미지


	
	

	@Override
	public String toString() {
		return "CartVo [userId=" + userId + ", prodNum=" + prodNum + ", prodName=" + prodName + ", price=" + price
				+ ", quantity=" + quantity + ", image=" + image + "]";
	}




	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
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


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
