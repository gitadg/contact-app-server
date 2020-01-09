package com.contact_app.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ContactsHardcodedService {

	private static List<Contact> contacts = new ArrayList<Contact>();
	private static long idCounter = 0;
	static {
		contacts.add(new Contact(++idCounter, "Joe", "bloe", "j@b.com", "555-555-5555"));
		contacts.add(new Contact(++idCounter, "Jane", "doe", "j@d.com", "555-555-5555"));

	}
	public List<Contact> findAll(){
		return contacts;
	}
	
	public Contact save(Contact contact) {
		if(contact.getId()==-1 || contact.getId()==0) {
			contacts.add(contact);
		} else {
			deleteById(contact.getId());
			contacts.add(contact);
		}
			return contact;
	}
	public Contact deleteById(long id) {
		Contact contact = findById(id);
		if(contact == null) {
			return null;
		}
		if(contacts.remove(contact)) {
			return contact;
		}
		return null;
	}

	private Contact findById(long id) {
		for(Contact contact:contacts) {
			if(contact.getId() == id) {
				return contact;
			}
		}
		return null;
	}
}
