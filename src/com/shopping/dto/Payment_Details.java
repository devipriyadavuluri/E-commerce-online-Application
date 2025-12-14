package com.shopping.dto;

import java.time.LocalDate;

public class Payment_Details {
	private int paymentId;
	private int cId;
	private int pId;
	private String paymentType;
	private String paymenStatus;
	private double paymentAmount;
	private LocalDate paymentDate;
	public Payment_Details()
	{
		
	}
	public Payment_Details(int paymentId, int cId, int pId, String paymentType, String paymenStatus, double paymentAmount,
			LocalDate paymentDate) {
		
		this.paymentId = paymentId;
		this.cId = cId;
		this.pId = pId;
		this.paymentType = paymentType;
		this.paymenStatus = paymenStatus;
		this.paymentAmount = paymentAmount;
		this.paymentDate = paymentDate;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymenStatus() {
		return paymenStatus;
	}
	public void setPaymenStatus(String paymenStatus) {
		this.paymenStatus = paymenStatus;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double uamount) {
		this.paymentAmount = uamount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment_Details [paymentId=" + paymentId + ", cId=" + cId + ", pId=" + pId + ", paymentType="
				+ paymentType + ", paymenStatus=" + paymenStatus + ", paymentAmount=" + paymentAmount + ", paymentDate="
				+ paymentDate + "]";
	}
	

}
