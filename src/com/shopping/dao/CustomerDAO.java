package com.shopping.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.dto.Customer_Details;
import com.shopping.util.JDBCConnection;

public class CustomerDAO {
	private static final  String insert="insert into customer_details ( Customer_Name, Customer_Email_Id, Customer_Mobile_Num, Customer_Adress, Customer_Gender, Customer_Password) values(?,?,?,?,?,?)";
	public boolean insertCustomerDetails(Customer_Details customer_Details)
	{
		
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1, customer_Details.getcName());
			preparedStatement.setString(2, customer_Details.getcEmail());
			preparedStatement.setLong(3, customer_Details.getcMobileNum());
			preparedStatement.setString(4, customer_Details.getcAdress());
			preparedStatement.setString(5, customer_Details.getcGender());
			preparedStatement.setString(6, customer_Details.getPassword());
			int result=preparedStatement.executeUpdate();
			if(result!=0)
				return true;
			else
				return false;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	private static final String Select="select * from  customer_details";
	
		
		public List<Customer_Details> selectAllCustomerDetails()
		{
			try {
				Connection connection=JDBCConnection.forMySQLConnection();
				PreparedStatement preparedstatement=connection.prepareStatement(Select);
				  ResultSet resultset=preparedstatement.executeQuery();
				  List<Customer_Details>listOfCustomerDetails=new ArrayList<Customer_Details>();
				  while(resultset.next())
				  {
					  Customer_Details customerDetails =new Customer_Details();
					  customerDetails.setcMobileNum(resultset.getLong("Customer_Mobile_Num"));
					  customerDetails.setPassowrd(resultset.getString("Customer_Password"));
					  customerDetails.setEmail(resultset.getString("Customer_Email_Id"));
					  listOfCustomerDetails.add(customerDetails);
					  
				  }
				  return listOfCustomerDetails;
		} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
		private static final String Select1="select * from customer_details where (Customer_Email_Id=? or Customer_Mobile_Num=?) and Customer_Password=?";
		public Customer_Details selectCustomerDetailsByUsingEmailOrMobileNum(String emailidOrMobileNUM,String password)
		{
			try {
				Connection connection=JDBCConnection.forMySQLConnection();
				PreparedStatement preparedstatement=connection.prepareStatement(Select1);
				preparedstatement.setString(1, emailidOrMobileNUM);
				preparedstatement.setString(2,emailidOrMobileNUM);
				preparedstatement.setString(3, password);
				ResultSet resultset=preparedstatement.executeQuery();
				if(resultset.next())
				{
					Customer_Details customerdetails=new Customer_Details();
					customerdetails.setcId(resultset.getInt("Customer_Id"));
					customerdetails.setcName(resultset.getString("Customer_Name"));
					customerdetails.setcAdress(resultset.getString("Customer_Adress"));
					customerdetails.setcGender(resultset.getString("Customer_Gender"));
					customerdetails.setcMobileNum(resultset.getLong("Customer_Mobile_Num"));
					return customerdetails;
				}
				else
				{
					return null;
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
			
		}
	

}
