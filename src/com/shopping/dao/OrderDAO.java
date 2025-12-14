package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.dto.Order_Details;
import com.shopping.util.JDBCConnection;

public class OrderDAO {
	private static final String insert="insert into order_details( Customer_Id, Product_Id, Product_Quantity, Order_Adress, Order_Date) values(?,?,?,?,?)";
	public boolean insertOrderDetails(Order_Details orderdetails)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setInt(1, orderdetails.getcId());
			preparedstatement.setInt(2, orderdetails.getpId());
			preparedstatement.setInt(3, orderdetails.getpQuantity());
			preparedstatement.setString(4, orderdetails.getoAdress());
			preparedstatement.setDate(5, Date.valueOf(orderdetails.getoDate()));
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

}
