package com.shopping.service;

import java.time.LocalDate;
import java.util.Scanner;

import com.shopping.dao.PaymentDAO;
import com.shopping.dto.Payment_Details;

public class PaymentService {
	Scanner sc=new Scanner(System.in);
	Payment_Details paymentdetails=new Payment_Details();
	PaymentDAO paymentdao=new PaymentDAO();
	public void paymentProcessDetails(int id,double amount,int pid)
	{
		paymentdetails.setcId(id);
		paymentdetails.setpId(pid);
		paymentdetails.setPaymentDate(LocalDate.now());
		System.out.println("Enter \n 1.For UPI  \n 2.Cash on Delivery \n 3.Debit \4. Net Payment \n 5.EMI");
		switch(sc.nextInt())
		{
		case 1:
		paymentdetails.setPaymentType("UPI");
		paymentdetails.setPaymenStatus(" Payment sucess");
		break;
		case 2:
			paymentdetails.setPaymentType("cash on delivery");
			paymentdetails.setPaymenStatus(" under processing");
			break;
		case 3:
			paymentdetails.setPaymentType("Debit card");
			paymentdetails.setPaymenStatus("payment sucessffully");
			break;
		case 4:
			paymentdetails.setPaymentType("Net payment");
			paymentdetails.setPaymenStatus("payment sucessffully");
			break;
		case 5:
			paymentdetails.setPaymentType("EMI");
			paymentdetails.setPaymenStatus("patment processing");
			break;
		default:
			break;
				
			
		}
		System.out.println("enter Amount:");
		double uamount=sc.nextDouble();
		if(uamount==amount)
		{
			paymentdetails.setcId(id);
			paymentdetails.setpId(pid);
			paymentdetails.setPaymentAmount(uamount);
			System.out.println(paymentdetails);
			if(paymentdao.InsertPaymentDetails(paymentdetails))
			{
				System.out.println("insert sucessfuly....");
			}
		}
		else
		{
			System.out.println("invalid amount");
		}
		
		
		
		
	}

}
