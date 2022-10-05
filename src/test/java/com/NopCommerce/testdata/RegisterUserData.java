package com.NopCommerce.testdata;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class RegisterUserData {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	String[] testData;
	
	public String[] registerUserData()
	{
		testData = new String[5];
		testData[0] = fake.name().firstName();
		testData[1] = fake.name().lastName();
		testData[2] = fake.bothify("????????#?#?@email.com");
		testData[3] = "test";
		testData[4] = "test@123";
		return testData;
	}
}
