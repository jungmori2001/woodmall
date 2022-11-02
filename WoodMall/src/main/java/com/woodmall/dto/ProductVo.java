package com.woodmall.dto;

import java.sql.Date;

public class ProductVo {
	private int prodNum;
	private String kind;
	private String prodName;	
	private int price;
	private String image;
	private String content;
	private Date reg_date;
	
	@Override
	public String toString() {
		return "ProductVo [prodnum=" + prodNum + ", kind=" + kind + ", prodname=" + prodName + ", price=" + price
				+ ", image=" + image + ", content=" + content +", reg_date" + reg_date + "]";
	}

	public int getProdNum() {
		return prodNum;
	}

	public void setProdNum(int prodNum) {
		this.prodNum = prodNum;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	
	
	
}
