package com.raghavrs.contactbook.service;

import java.util.List;
import com.raghavrs.contactbook.model.entity.Contact;

public interface ContactService {
	public void addContact(Contact contact);
	public List<Contact> getAllContancts();
	public void updateContact(Contact contact);
	public Contact getContact(Long id);
	public void deleteContact(Long id);

}
