package com.raghavrs.contactbook.model.dto.response;

public class ResponseContactDTO {

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
	public ResponseContactDTO(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public ResponseContactDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ResponseContactDTO [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
