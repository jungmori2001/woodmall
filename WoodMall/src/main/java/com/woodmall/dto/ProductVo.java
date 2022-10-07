package com.woodmall.dto;

import java.sql.Date;

public class ProductVo {
	private int prodnum;
	private String kind;
	private String prodname;	
	private int price;
	private String image;
	private String content;
	private Date reg_date;
	
	@Override
	public String toString() {
		return "ProductVo [prodnum=" + prodnum + ", kind=" + kind + ", prodname=" + prodname + ", price=" + price
				+ ", image=" + image + ", content=" + content +", reg_date" + reg_date + "]";
	}

	public int getProdnum() {
		return prodnum;
	}
	public void setProdnum(int prodnum) {
		this.prodnum = prodnum;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
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
