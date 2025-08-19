package com.ui.pojos;

public class AddressPOJO {
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String postalCode;
	private String additionalInfo;
	private String addressTitle;
	private String state;

	public AddressPOJO(String companyName, String addressLine1, String addressLine2, String city,
			String homePhoneNumber, String mobilePhoneNumber, String postalCode, String additionalInfo,
			String addressTitle, String state) {
		super();
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.postalCode = postalCode;
		this.additionalInfo = additionalInfo;
		this.addressTitle = addressTitle;
		this.state = state;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getAddressTitle() {
		return addressTitle;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "AddressPOJO [companyName=" + companyName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", homePhoneNumber=" + homePhoneNumber + ", mobilePhoneNumber="
				+ mobilePhoneNumber + ", postalCode=" + postalCode + ", additionalInfo=" + additionalInfo
				+ ", addressTitle=" + addressTitle + ", state=" + state + "]";
	}

}
