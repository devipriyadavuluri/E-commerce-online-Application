package com.shopping.Exception;

public class CustomerDataInvalidException extends RuntimeException{

	private String exception;
	
	
	public CustomerDataInvalidException()
	{
		
	}

	public CustomerDataInvalidException(String exception) {
		this.exception = exception;
	}
	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "CustomerDataInvalidException [exception=" + exception + "]";
	}

	
	

}
