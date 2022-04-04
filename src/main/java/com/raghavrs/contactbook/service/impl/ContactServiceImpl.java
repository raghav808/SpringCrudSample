package com.raghavrs.contactbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.raghavrs.contactbook.model.entity.Contact;
import com.raghavrs.contactbook.repository.ContactRepository;
import com.raghavrs.contactbook.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public List<Contact> getAllContancts() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> searchContacts(String input) {
		return contactRepository.findAll(containsNumberOrName(input));
	}

	private Specification<Contact> containsNumberOrName(String input) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			predicates.add(
					criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + input.toUpperCase() + "%"));
			predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("phoneNumber")),
					"%" + input.toUpperCase() + "%"));

			return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
		};
	}

	@Override
	public void addContact(Contact contact) {
		contactRepository.save(contact);

	}

	@Override
	public void updateContact(Contact contact) {
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
