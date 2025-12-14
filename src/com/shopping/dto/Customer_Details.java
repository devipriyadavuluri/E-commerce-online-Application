package com.shopping.dto;

public class Customer_Details {
	private int cId;
	private String cName;
	private long cMobileNum;
	private String cAdress;
	private String cGender;
	private String cemail;
	private String password;
	public Customer_Details()
	{
		
	}
	public Customer_Details(int cId, String cName, long cMobileNum, String cAdress, String cGender, String cemail,String passowrd) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cMobileNum = cMobileNum;
		this.cAdress = cAdress;
		this.cGender = cGender;
		this.cemail = cemail;
		this.password=password;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public long getcMobileNum() {
		return cMobileNum;
	}
	public void setcMobileNum(long cMobileNum) {
		this.cMobileNum = cMobileNum;
	}
	public String getcAdress() {
		return cAdress;
	}
	public void setcAdress(String cAdress) {
		this.cAdress = cAdress;
	}
	public String getcGender() {
		return cGender;
	}
	public void setcGender(String cGender) {
		this.cGender = cGender;
	}
	public String getcEmail() {
		return cemail;
	}
	public void setEmail(String cemail) {
		this.cemail = cemail;
	}
	public void setPassowrd(String passowrd)
	{
		this.password=passowrd;
	}
	public String getPassword()
	{
		return password;
	}
	
	@Override
	public String toString() {
		return "Customer_Details cId=" + cId + ", cName=" + cName + ", cMobileNum=" + cMobileNum + ", cAdress="
				+ cAdress + ", cGender=" + cGender + ", cemail=" + cemail +", Passowrd ="+password ;
	}
	
}
