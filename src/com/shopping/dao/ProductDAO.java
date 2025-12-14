package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcConnection;
import com.shopping.dto.Product_Detials;
import com.shopping.util.JDBCConnection;

public class ProductDAO {
	Scanner sc=new Scanner(System.in);
	private final static String insert="insert into product_details( Product_Name, Product_Brand, Product_Price, Product_M_F_Date, Product_Ex_Date, Product_Quantity, Product_Category, Product_Discount) values(?,?,?,?,?,?,?,?)";
	
	public boolean insertProductDetails(Product_Detials productdetails)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparestatement=connection.prepareStatement(insert);
			preparestatement.setString(1, productdetails.getpName());
			preparestatement.setString(2, productdetails.getpBrand());
			preparestatement.setDouble(3, productdetails.getpPrice());
			preparestatement.setDate(4, productdetails.getpMFDate());
			preparestatement.setDate(5, productdetails.getpExpDate());
			preparestatement.setInt(6, productdetails.getpQuantity());
			preparestatement.setString(7,productdetails.getpCategory());
			preparestatement.setDouble(8, productdetails.getPdiscount());
			int resultset=preparestatement.executeUpdate();
			if(resultset!=0)
				return true;
			else
				return false;
		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		
		}
		
	}
	public boolean insertMoreThanOneProduct(List<Product_Detials> list)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparestatement=connection.prepareStatement(insert);
			for(Product_Detials productdetails:list)
			{
			preparestatement.setString(1, productdetails.getpName());
			preparestatement.setString(2, productdetails.getpBrand());
			preparestatement.setDouble(3, productdetails.getpPrice());
			preparestatement.setDate(4, productdetails.getpMFDate());
			preparestatement.setDate(5, productdetails.getpExpDate());
			preparestatement.setInt(6, productdetails.getpQuantity());
			preparestatement.setString(7,productdetails.getpCategory());
			preparestatement.setDouble(8, productdetails.getPdiscount());
			
			preparestatement.addBatch();
			}
			int result[]=preparestatement.executeBatch();
			if(result.length!=0)
				return true;
			else
				return false;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	private final static String select="select * from product_details";
	public  List<Product_Detials> SelectProductDetails()
	{
		 try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparestatement=connection.prepareStatement(select);
			ResultSet resultset=preparestatement.executeQuery();
			List<Product_Detials>list=new ArrayList<Product_Detials>();
			if(resultset.isBeforeFirst())
			{
			while(resultset.next())
			{
			//resultset.getString(prodcutdetails.getpName());
			//	resultset.getString(prodcutdetails.getpCategory());
			//	resultset.getString(prodcutdetails.getpBrand());
			//	resultset.getInt(prodcutdetails.getpQuantity());
		    //resultset.getDouble(prodcutdetails.getPdiscount());
			//resultset.getDouble(prodcutdetails.getPdiscount());
				Product_Detials productdetails=new Product_Detials();
				productdetails.setpId(resultset.getInt("Product_Id"));
				productdetails.setpName(resultset.getString("Product_Name"));
				productdetails.setpPrice(resultset.getDouble("Product_Price"));
				productdetails.setpBrand(resultset.getString("Product_Brand"));
				productdetails.setpMFDate(resultset.getDate("Product_M_F_Date"));
				productdetails.setpExpDate(resultset.getDate("Product_Ex_Date"));
				productdetails.setpQuantity(resultset.getInt("Product_Quantity"));
				productdetails.setpCategory(resultset.getString("Product_Category"));
				productdetails.setPdiscount(resultset.getDouble("Product_Discount"));
				list.add(productdetails);
			}
			
			}
			return list;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		
	
		
		
	}

}
