package com.raghavrs.contactbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.raghavrs.contactbook.model.entity.Contact;

public interface ContactRepository extends JpaSpecificationExecutor<Contact>, JpaRepository<Contact, Long>{
//	Optional<Contact> findByPhoneNumber(String phoneNumber);
//	Optional<Contact> findByName(String name);
}
