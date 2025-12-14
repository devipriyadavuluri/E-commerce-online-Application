package com.shopping.dto;

public class Cart_Details {
	private int cartId;
	private int pId;
	private int cId;
	private int pQuantity;
	public Cart_Details()
	{
		
	}
	public Cart_Details(int cartId, int pId, int cId, int pQuantity) {
		super();
		this.cartId = cartId;
		this.pId = pId;
		this.cId = cId;
		this.pQuantity = pQuantity;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	@Override
	public String toString() {
		return "Cart_Details [cartId=" + cartId + ", pId=" + pId + ", cId=" + cId + ", pQuantity=" + pQuantity + "]";
	}
	

}
