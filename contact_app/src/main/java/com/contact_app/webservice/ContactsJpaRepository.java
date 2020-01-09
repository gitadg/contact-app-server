package com.contact_app.webservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsJpaRepository extends JpaRepository<Contact, Long>{
	List<Contact> findAll();

}

