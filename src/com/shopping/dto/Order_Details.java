package com.shopping.dto;

import java.time.LocalDate;

public class Order_Details {
	private int oId;
	private int cId;
	private int pId;
	private int pQuantity;
	private String oAdress;
	private LocalDate oDate;
	public Order_Details()
	{
		
	}
	public Order_Details(int oId, int cId, int pId, int pQuantity, String oAdress, LocalDate oDate) {
		super();
		this.oId = oId;
		this.cId = cId;
		this.pId = pId;
		this.pQuantity = pQuantity;
		this.oAdress = oAdress;
		this.oDate = oDate;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public String getoAdress() {
		return oAdress;
	}
	public void setoAdress(String oAdress) {
		this.oAdress = oAdress;
	}
	public LocalDate getoDate() {
		return oDate;
	}
	public void setoDate(LocalDate oDate) {
		this.oDate = oDate;
	}
	@Override
	public String toString() {
		return "Order_Details [oId=" + oId + ", cId=" + cId + ", pId=" + pId + ", pQuantity=" + pQuantity + ", oAdress="
				+ oAdress + ", oDate=" + oDate + "]";
	}
	
}
