package com.shopping.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.shopping.Exception.CustomerDataInvalidException;
import com.shopping.dao.CustomerDAO;
import com.shopping.dto.Cart_Details;
import com.shopping.dto.Customer_Details;
import com.shopping.dto.Order_Details;
import com.shopping.dto.Payment_Details;
import com.shopping.dto.Product_Detials;

public class CustomerService {
	Scanner sc=new Scanner(System.in);
	CustomerDAO customerDao=new CustomerDAO();
	Customer_Details customer_details;
	ProductService productservice=new ProductService();
	Product_Detials productdetails=new Product_Detials();
	CartService cartservice=new CartService();
	Order_Details orderdetails=new Order_Details();
	List<Customer_Details>list=customerDao.selectAllCustomerDetails();
	Payment_Details paymentdetails=new Payment_Details();
	OrderService orderservice=new OrderService();
	public void customeregistration()
	{
		System.out.println("enter customer name:");
		String cname=sc.next();
		System.out.println("enter customer emailId ");
		while(true)
		{
		String cemail=sc.next();
		long emailidcount=list.stream().filter((customer)->customer.getcEmail().equals(cemail)).count();
		try
		{
			
			if(!cemail.contains("@gmail.com"))
			{
				throw new CustomerDataInvalidException("Invalid emailId");
			}
			if(emailidcount>0)
			{
				throw new CustomerDataInvalidException("emailid already exsiting..............");
			}
			else
			{
				customer_details.setEmail(cemail);
				break;
			}
		}
		catch(CustomerDataInvalidException e)
		{
			System.out.println(e.getException());
			System.out.println(" emailId is alreay exisitence ");
		}
		
		}
		System.out.println("enter customer mobile number");
		while(true)
		{
		long cMobileNum=sc.nextLong();
		
		long mobileNum=list.stream().filter((mobilenum)->mobilenum.getcMobileNum()==(cMobileNum)).count();
		try
		{
			if(mobileNum>0)
			{
				 throw new CustomerDataInvalidException("mobilenum is already exisiting.....");
			}
			if(!(cMobileNum>=6000000000l && cMobileNum<=9999999999l))
			{
				
				throw new CustomerDataInvalidException("Invalid mobile number");
			}
			else
			{
				customer_details.setcMobileNum(cMobileNum);
				break;
			}
		}
		catch(CustomerDataInvalidException e)
		{
			System.out.println(e.getException());
			System.out.println("enter valid mobile number..");
		}
		}
		
		System.out.println("enter customer adress");
		String adress=sc.next();
		System.out.println("enter gender ");
		String cgender=sc.next();
		if(!(cgender.equalsIgnoreCase("Female")||cgender.equalsIgnoreCase("Male")||cgender.equalsIgnoreCase("M")||cgender.contains("F")))
		{
			throw new CustomerDataInvalidException("Invalid gender");
		}
		System.out.println("enter password");
		String password=sc.next();
		customer_details.setcName(cname);
		customer_details.setcAdress(adress);
		customer_details.setcGender(cgender);
		customer_details.setPassowrd(password);
		if(customerDao.insertCustomerDetails(customer_details))
		{
			System.out.println(customer_details.getcName()+"registration ssucessfully.......");
		}
		else
		{
			System.out.println("server 500");
		}
	}
	public void CustomerLogin()
	{
		System.out.println("enter Email id Or MobileNumber... ");
		String EmailIdOrMobileNum=sc.next();
		System.out.println("enter passowrd");
		String password=sc.next();
		customer_details =customerDao.selectCustomerDetailsByUsingEmailOrMobileNum(EmailIdOrMobileNum, password);
		if(customer_details!=null)
		{
			System.out.println("login succesfully............................");
			
			if(customer_details.getcGender().equalsIgnoreCase("female") || customer_details.getcGender().equalsIgnoreCase("f"))
			{
				System.out.println("Hello Miss:"+customer_details.getcName());
				CustomerOperation();
			}
			if(customer_details.getcGender().equalsIgnoreCase("male") || customer_details.getcGender().equalsIgnoreCase("M"))
	     	{
			System.out.println("Hello Mr's:"+customer_details.getcName());
			CustomerOperation();
		    }
		}
	}
			public void CustomerOperation()
			{
			
			System.out.println("Enter :\n 1.For all product details \n 2.for cart details \n 3. for order details");
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("for all product details");
				int i=1;
				List<Product_Detials>allproductdetails=productservice.AllProductDetails();
				for(Product_Detials productDetails:allproductdetails)
				{
					System.out.println("SINO :"+i++);
					System.out.println("product name:"+productDetails.getpName());
					System.out.println("product brand:"+productDetails.getpCategory());
					System.out.println("product price:"+productDetails.getpPrice());
					System.out.println("product discount:"+productDetails.getPdiscount());
					System.out.println("product manufacture date:"+productDetails.getpMFDate());
					System.out.println("product Expire date:"+productDetails.getpExpDate());
					System.out.println("--------------------------------------------------");
				}
				System.out.println("select SINO to Add to cart or TO Buy");
				Product_Detials productdetails=allproductdetails.get(sc.nextInt()-1);
				System.out.println("product name:"+productdetails.getpName());
				System.out.println("product brand:"+productdetails.getpCategory());
				System.out.println("product price:"+productdetails.getpPrice());
				System.out.println("product discount:"+productdetails.getPdiscount());
				System.out.println("product manufacture date:"+productdetails.getpMFDate());
				System.out.println("product Expire date:"+productdetails.getpExpDate());
				System.out.println("--------------------------------------------------");
				System.out.println("enter \n 1.Add the product To cart \n 2.buy the product");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Add the product:");
					System.out.println("enter the product quntity :");
					int quantity=sc.nextInt();
					Cart_Details cartdetails=new Cart_Details();
					cartdetails.setcId(customer_details.getcId());	
					cartdetails.setpId(productdetails.getpId());
					cartdetails.setpQuantity(quantity);
					cartservice.addCartDetails(cartdetails);
					break;
				case 2:
					System.out.println("buy the product");
				System.out.println("enter the quantity");
				int pquantity=sc.nextInt();
				double totalprice=productdetails.getpPrice()*pquantity;
				double discount=totalprice*(productdetails.getPdiscount()/100);
				double price=totalprice-discount;
				System.out.println("prodcut name:"+productdetails.getpName());
				System.out.println("product brand:"+productdetails.getpBrand());
				System.out.println("product category:"+productdetails.getpCategory());
				System.out.println("single product price RS:"+productdetails.getpPrice());
				System.out.println("Total product price Rs:"+totalprice);
				System.out.println("Discount price:"+discount);
				System.out.println("Final product price (M.R.P)"+price);
				PaymentService paymentservice=new PaymentService();
				System.out.println("-----------------------------------");
				paymentservice.paymentProcessDetails(customer_details.getcId(),price,productdetails.getpId());
			
				orderdetails=orderservice.getOrderDetails(customer_details.getcId(), productdetails.getpId(), pquantity,customer_details.getcAdress());
				
				System.out.println("select Address to Deliver the product \n "+customer_details.getcAdress() +"\n 2.change adress");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println(customer_details.getcAdress());
					break;
				case 2:
					System.out.println("change address");
					String address=sc.next();
					orderdetails.setoAdress(address);
					 System.out.println(orderdetails);
					 break;		 
				}
				break;
			
			case 3:
				System.out.println("Cart Details");
	
				break;
			case 4:
				System.out.println("Invalid option");
				break;
			}
			}
			}
			
	}

	


