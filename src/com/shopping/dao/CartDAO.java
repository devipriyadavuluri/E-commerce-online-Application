package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.dto.Cart_Details;
import com.shopping.util.JDBCConnection;

public class CartDAO {
	private final static String insert="insert into cart_details( Product_Id, Customer_Id, Product_Quantity) values(?,?,?)";
	public boolean insertCartDetails(Cart_Details cartdetails)
	{
		 try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setInt(1, cartdetails.getpId());
			preparedstatement.setInt(2, cartdetails.getcId());
			preparedstatement.setInt(3,cartdetails.getpQuantity());
			int resultset=preparedstatement.executeUpdate();
			if(resultset!=0)
			{
				return true;
			}
			else
			{
				return false;
			}
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		 
		
	}
	

}
