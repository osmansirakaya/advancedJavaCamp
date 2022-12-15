package com.springdemo;

public class MySqlCustomerDal implements ICustomerDal{
	
String connectiString;
	
	public String getConnectiString() {
		return connectiString;
	}

	public void setConnectiString(String connectiString) {
		this.connectiString = connectiString;
	}


	@Override
	public void add() {
		System.out.println("connection string: "+this.connectiString);
		System.out.println("mysql veri tabanına eklendi");
		
	}

}
