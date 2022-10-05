package com.NopCommerce.testdata;

public class LoginData {

	String[] testData;
	
	public String[] getValidLoginData()
	{
		testData = new String[2];
		testData[0] = "admin@yourstore.com";
		testData[1] = "admin";
		return testData;
	}
	
	public String[] getInValidLoginData()
	{
		testData = new String[2];
		testData[0] = "test@123.com";
		testData[1] = "1234";
		return testData;
	}
}
