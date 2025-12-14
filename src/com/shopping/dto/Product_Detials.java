package com.shopping.dto;

import java.sql.Date;

public class Product_Detials {
	private int pId;
	private String pName;
	private String pBrand;
	private double pPrice;
	private Date pMFDate;
	private Date pExpDate;
	private int pQuantity;
	private String pCategory;
	private double pdiscount;
	public  Product_Detials()
	{
		
	}
	public Product_Detials(int pId, String pName, String pBrand, double pPrice, Date pMFDate, Date pExpDate,
			int pQuantity, String pCategory, double pdiscount) {
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pPrice = pPrice;
		this.pMFDate = pMFDate;
		this.pExpDate = pExpDate;
		this.pQuantity = pQuantity;
		this.pCategory = pCategory;
		this.pdiscount = pdiscount;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public Date getpMFDate() {
		return pMFDate;
	}
	public void setpMFDate(Date pMFDate) {
		this.pMFDate = pMFDate;
	}
	public Date getpExpDate() {
		return pExpDate;
	}
	public void setpExpDate(Date pExpDate) {
		this.pExpDate = pExpDate;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public double getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(double pdiscount) {
		this.pdiscount = pdiscount;
	}
	@Override
	public String toString() {
		return "Product_Detials pId=" + pId + ", pName=" + pName + ", pBrand=" + pBrand + ", pPrice=" + pPrice
				+ ", pMFDate=" + pMFDate + ", pExpDate=" + pExpDate + ", pQuantity=" + pQuantity + ", pCategory="
				+ pCategory + ", pdiscount=" + pdiscount + "]";
	}
	
	

}
