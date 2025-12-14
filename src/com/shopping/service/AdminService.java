package com.shopping.service;

import java.util.Scanner;

import com.shopping.Exception.CustomerDataInvalidException;
import com.shopping.dao.AdminDAO;
import com.shopping.dao.ProductDAO;
import com.shopping.dto.Admin_Details;

public class AdminService {
	Scanner sc=new Scanner(System.in);
	ProductService productservice=new ProductService();
	Admin_Details admindetails=new Admin_Details();
	AdminDAO admindao=new AdminDAO();
	public void AdminRegistration()
	{

		System.out.println("enter email id:");
		String emailId=sc.next();
		if(!emailId.endsWith("@gmail.com"))
		{
			throw new CustomerDataInvalidException();
		}
		System.out.println("enter admin password:");
		String password=sc.next();
		System.out.println("enter admin role:");
		String role=sc.next();
		admindetails.setaEmailId(emailId);
		admindetails.setaPassowrd(role);
		admindetails.setaRole(role);
		admindao.insertAdminDetails(admindetails);
	}
	public void AdminLoginVerification()
	{
		System.out.println("enter customer email id");
		String emailId=sc.next();
		System.out.println("enter password:");
		String password=sc.next();
        if(admindao.SelectAdminDetailsByUsingEmail(emailId,password))
        {
        	boolean result=true;
        	while(result)
        	{
        		System.out.println("enter "+"\n 1.Insert Product details \n 2.select product details \n 3.exit");
        		switch(sc.nextInt())
        		{
        		case 1:
        		productservice.ProductStorageDetails();
        		break;
        		case 2:
        		System.out.println("Insert product Brands............");
        		productservice.storeProductByUsingBrand();
        		break;
        		case 3:
        			System.out.println("exit");
        			result=false;
        		break;
        		}
        	}
        }
		
	}
			
	

}
