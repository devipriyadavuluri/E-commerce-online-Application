package com.shopping.dto;

public class Admin_Details {
	private int aId;
	private String aEmailId;
	private String aPassowrd;
	private String aRole;
	public Admin_Details()
	{
		
	}
	public Admin_Details(int aId, String aEmailId, String aPassowrd, String aRole) {
		super();
		this.aId = aId;
		this.aEmailId = aEmailId;
		this.aPassowrd = aPassowrd;
		this.aRole = aRole;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaEmailId() {
		return aEmailId;
	}
	public void setaEmailId(String aEmailId) {
		this.aEmailId = aEmailId;
	}
	public String getaPassowrd() {
		return aPassowrd;
	}
	public void setaPassowrd(String aPassowrd) {
		this.aPassowrd = aPassowrd;
	}
	public String getaRole() {
		return aRole;
	}
	public void setaRole(String aRole) {
		this.aRole = aRole;
	}
	@Override
	public String toString() {
		return "Admin_Details [aId=" + aId + ", aEmailId=" + aEmailId + ", aPassowrd=" + aPassowrd + ", aRole=" + aRole
				+ "]";
	}

}
