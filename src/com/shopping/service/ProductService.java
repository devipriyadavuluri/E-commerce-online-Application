package com.shopping.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shopping.dao.ProductDAO;
import com.shopping.dto.Product_Detials;
public class ProductService {
	Scanner sc=new Scanner(System.in);
	ProductDAO productdao=new ProductDAO();
	public void ProductStorageDetails()
	{
		System.out.println("enter product name:");
		String pname=sc.next();
		System.out.println("enter product brand:");
		String pbrand=sc.next();
		System.out.println("enter product price");
		 double price=sc.nextDouble();
		 System.out.println("enter product manufactire date");
		 String MFDproduct=sc.next();
		 System.out.println("enter product expired date:");
		 String EXPproduct=sc.next();
		 System.out.println("enter product quantity:");
		 int quantity=sc.nextInt();
		 System.out.println("enter product  discount");
		 double discount=sc.nextDouble();
		 System.out.println("enter product category");
		 String categor=sc.next();
		 Product_Detials productDetails=new Product_Detials();
		 productDetails.setpName(pname);
		 productDetails.setpBrand(pbrand);
		 productDetails.setpPrice(price);
		 productDetails.setpMFDate(Date.valueOf(MFDproduct));
		 productDetails.setpExpDate(Date.valueOf(EXPproduct));
		 productDetails.setpQuantity(quantity);
		 productDetails.setPdiscount(discount);
		 productDetails.setpCategory(categor);
		 /* insert product details*/
		 productdao.insertProductDetails(productDetails);	
	}
	public void storeProductByUsingBrand()
	{
		List<Product_Detials>list=new ArrayList<Product_Detials>();
		System.out.println("enter product brand :");
		String pbrand=sc.next();
		System.out.println("Number  of produts under"+pbrand+"Brand");
		int number=sc.nextInt();
		String nu[]={"first","second","third","fouth","fith"};
		for(int i=0; i<number; i++)
		{
			System.out.println("enter "+nu[i]+"product details");
			System.out.println("enter product name:");
			String pname=sc.next();
			 System.out.println("enter product category:");
			 String pcategory=sc.next();
			System.out.println("enter product price:");
			double pprice=sc.nextDouble();
			System.out.println("enter product manufactire date");
			 String MFDproduct=sc.next();
			 System.out.println("enter product expired date:");
			 String EXPproduct=sc.next();
			 System.out.println("enter product quantity:");
			 int quantity=sc.nextInt();
			 System.out.println("enter product  discount");
			 double discount=sc.nextDouble();
			 Product_Detials productDetails=new Product_Detials();
			 productDetails.setpName(pname);
			 productDetails.setpCategory(pcategory);
			 productDetails.setpBrand(pbrand);
			 productDetails.setpPrice(pprice);
			 productDetails.setpMFDate(Date.valueOf(MFDproduct));
			 productDetails.setpExpDate(Date.valueOf(EXPproduct));
			 productDetails.setpQuantity(quantity);
			 productDetails.setPdiscount(discount);
			 productDetails.setpBrand(pcategory);
			 list.add(productDetails);
		}
		if(productdao.insertMoreThanOneProduct(list))
		{
			System.out.println("insert sucessfully....................:");
		}
		else
		{
			System.out.println("server error 500:");
		}
	}
	public List<Product_Detials> AllProductDetails()
	{
		List<Product_Detials>list=productdao.SelectProductDetails();
		return list;
	}

}
