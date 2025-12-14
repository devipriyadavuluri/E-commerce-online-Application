package com.shopping.main;

import java.util.Scanner;

import com.shopping.service.AdminService;
import com.shopping.service.CustomerService;

public class Main {
public static void main(String[] args) {
	CustomerService  customerService =new CustomerService();
	AdminService adminservice=new AdminService();
	Scanner sc=new Scanner(System.in );
	CustomerService cs=new CustomerService();
	boolean result=true;
	
	while(result)
	{
	
	System.out.println("Enter \n 1.For Admin login \n 2.For Customer Registration \n 3.For Customer Login \n 4.Exit");
	
	switch(sc.nextInt())
	{
	case 1:
		System.out.println("Admin Login:");
	//	adminservice.AdminLoginVerififcation();
		adminservice.AdminLoginVerification();
		break;
	case 2:
		System.out.println("Customer Registration:");
		customerService.customeregistration();
		
		break;
	case 3:
		System.out.println("Customer Login:");
		cs.CustomerLogin();
		break;
	case 4:
		System.out.println("thank you.............");
		result=false;
		break;
	default:
		System.out.println("Invalid Request");
		break;
	}
	System.out.println("Do You want continue......"+"\n yes"+"\n no");
	boolean isContinue=true;
	if(isContinue)
	{
		isContinue=sc.nextBoolean();
	}
	else
	{
		isContinue=false;
		
	}
		
	}
	
	}
	

}
