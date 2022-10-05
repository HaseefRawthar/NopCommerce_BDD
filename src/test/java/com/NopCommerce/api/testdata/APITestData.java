package com.NopCommerce.api.testdata;

import java.util.Locale;

import com.NopCommerce.baseclass.SetUp;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class APITestData extends SetUp {

	Locale local = new Locale("en-IND");
	Faker fake = new Faker(local);
	FakeValuesService fakeService = new FakeValuesService(local, new RandomService());
	String[] testData;
	
	public String[] apiData()
	{
		testData = new String[2];
		testData[0] = fake.name().firstName();
		testData[1] = fake.bothify("????????#?#?@email.com");
		return testData;
	}
}
