package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.OrderDAO;
import com.shopping.dto.Order_Details;

public class OrderService {
	Scanner sc=new Scanner(System.in);
	public Order_Details getOrderDetails(int cid,int pid,int quantity,String address)
	{
		Order_Details orderdetails=new Order_Details();
		OrderDAO orderdao=new OrderDAO();
		orderdetails.setcId(cid);
		orderdetails.setpId(pid);
		orderdetails.setoDate(LocalDate.now());
		orderdetails.setpQuantity(quantity);
		orderdetails.setoAdress(address);
		
		if(orderdao.insertOrderDetails(orderdetails))
		{
		    return orderdetails;
		}
		else
		{
			return null;
		}
	}

}
