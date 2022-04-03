package com.raghavrs.contactbook.model.dto.request;

public class ContactDTO {

	private String name;
	private String phoneNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ContactDTO(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public ContactDTO() {
		super();
	}
	@Override
	public String toString() {
		return "RequestContactDTO [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
}
