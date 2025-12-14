package com.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.JdbcConnection;
import com.shopping.dto.Admin_Details;
import com.shopping.util.JDBCConnection;

public class AdminDAO {
	Scanner sc=new Scanner(System.in);
	private final static String insert="insert into admin_details( Admin_Email_Id, Admin_Password, Admin_Role)values(?,?,?)";
	public boolean insertAdminDetails(Admin_Details admindetails)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparestatement=connection.prepareStatement(insert);
			preparestatement.setString(1, admindetails.getaEmailId());
			preparestatement.setString(2, admindetails.getaPassowrd());
			preparestatement.setString(3, admindetails.getaRole());
			int resultSet=preparestatement.executeUpdate();
			if(resultSet!=0)
				return true;
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
		
    }
	private final static String select="select * from admin_details where Admin_Email_Id=? and Admin_Password=?";
	public  boolean SelectAdminDetailsByUsingEmail(String Email,String password)
	{
		
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(select);
			preparedstatement.setString(1, Email);
			preparedstatement.setString(2, password);
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
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
