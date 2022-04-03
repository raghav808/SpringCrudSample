package com.raghavrs.contactbook.service;

import java.util.List;

import com.raghavrs.contactbook.model.dto.response.ResponseContactDTO;
import com.raghavrs.contactbook.model.entity.Contact;

public interface ContactService {

//	public ResponseContactDTO addContact(RequestContactDTO contactDTO);
	public void addContact(Contact contact);

//	public List<ResponseContactDTO> getAllContancts();
	public List<Contact> getAllContancts();

	public List<ResponseContactDTO> searchByNumber(String number);
	
	public List<ResponseContactDTO> searchByName(String name);

	public void updateContact(Contact contact);

	public Contact getContact(Long id);

	public void deleteContact(Long id);

}
