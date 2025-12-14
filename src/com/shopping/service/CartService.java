package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import com.shopping.dao.CartDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.Cart_Details;
import com.shopping.dto.Product_Detials;

public class CartService {
	CartDAO cartdao=new CartDAO();
	ProductDAO productdao=new ProductDAO();
	
	public void  addCartDetails(Cart_Details cartdetails)
	{
		if(cartdao.insertCartDetails(cartdetails))
		{
			System.out.println("product added to cart..........");
		}
		else
		{
			System.out.println("server error 500");
		}
		
	}
	public void selectProductDetails()
	{
		List<Product_Detials> product=productdao.SelectProductDetails();
	}

}
