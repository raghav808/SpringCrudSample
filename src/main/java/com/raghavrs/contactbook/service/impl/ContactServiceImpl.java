package com.raghavrs.contactbook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.raghavrs.contactbook.model.dto.response.ResponseContactDTO;
import com.raghavrs.contactbook.model.entity.Contact;
import com.raghavrs.contactbook.repository.ContactRepository;
import com.raghavrs.contactbook.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	/*
	@Override
	public ResponseContactDTO addContact(RequestContactDTO contactDTO) {
		Contact contact = new Contact();
		BeanUtils.copyProperties(contactDTO, contact);
		contact = contactRepository.save(contact);
		return new ResponseContactDTO(contact.getName(), contact.getPhoneNumber());
	}

	@Override
	public List<ResponseContactDTO> getAllContancts() {
		return contactRepository.findAll().stream()
				.map(contact -> new ResponseContactDTO(contact.getName(), contact.getPhoneNumber())).toList();
	}
	*/
	
	@Override
	public List<Contact> getAllContancts() {
		return contactRepository.findAll();
	}

	@Override
	public List<ResponseContactDTO> searchByNumber(String number) {
		return contactRepository.findAll(containsNumber(number)).stream()
				.map(contact -> new ResponseContactDTO(contact.getName(), contact.getPhoneNumber())).toList();	}

	@Override
	public List<ResponseContactDTO> searchByName(String name) {
		return contactRepository.findAll(containsName(name)).stream()
				.map(contact -> new ResponseContactDTO(contact.getName(), contact.getPhoneNumber())).toList();
	}

	private Specification<Contact> containsName(String name) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%");
	}

	private Specification<Contact> containsNumber(String number) {
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("phoneNumber")), "%" + number.toUpperCase() + "%");
	}

	@Override
	public void addContact(Contact contact) {
		contactRepository.save(contact);
		
	}

	@Override
	public void updateContact(Contact contact) {
//		Contact dbContact = 
		contactRepository.save(contact);
		
	}

	@Override
	public Contact getContact(Long id) {
		return contactRepository.getById(id);
	}

	@Override
	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
		
	}

}
