package com.raghavrs.contactbook.service;

import java.util.List;

import com.raghavrs.contactbook.model.entity.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public void updateContact(Contact contact);

	public void deleteContact(Long id);

	public List<Contact> getAllContancts();

	public List<Contact> searchContacts(String input);

	public Contact getContact(Long id);

}
