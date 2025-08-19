package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPOJO;

public class FakerUitility {

	public static AddressPOJO getFakerAddress() {
		Faker faker = new Faker(Locale.US);
		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetName(), faker.address().city(), faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(), faker.address().zipCode(), faker.random().toString(), "Home Address",
				faker.address().state());
		// TODO Auto-generated method stub
		return addressPOJO;
	}

}
