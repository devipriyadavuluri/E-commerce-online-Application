package com.shopping.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.shopping.dto.Payment_Details;
import com.shopping.util.JDBCConnection;

public class PaymentDAO {
	private final static String insert="insert into payment_details( Customer_Id, Product_Id, Payment_Type, Payment_Status, Payment_Amount, Payment_Date) values(?,?,?,?,?,?)";
	public boolean InsertPaymentDetails(Payment_Details  paymentdetails)
	{
		try {
			Connection connection=JDBCConnection.forMySQLConnection();
			PreparedStatement preparedstatement=connection.prepareStatement(insert);
			preparedstatement.setInt(1,paymentdetails.getcId() );
			preparedstatement.setInt(2, paymentdetails.getpId());
			preparedstatement.setString(3, paymentdetails.getPaymentType());
			preparedstatement.setString(4, paymentdetails.getPaymenStatus());
			preparedstatement.setDouble(5, paymentdetails.getPaymentAmount());
			preparedstatement.setDate(6, Date.valueOf(paymentdetails.getPaymentDate()));
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
