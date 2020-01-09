package com.contact_app.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContactsJpaResource {
	
	@Autowired
	private ContactsHardcodedService contactService;
	
	@Autowired
	private ContactsJpaRepository contactJpaRepository;
	
	@GetMapping("/jpa/contacts")
	public List<Contact> getAllContacts(Long id){
		return contactJpaRepository.findAll();
		//return contactService.findAll();
	}
	@PostMapping("/jpa/add")
	public ResponseEntity<Void> saveContact( @RequestBody Contact contact){
			Contact contactAdded = contactJpaRepository.save(contact);
			return ResponseEntity.accepted().build();
	}
	@PutMapping("/jpa/update/{id}")
	public ResponseEntity<Contact> updateContact(
		@PathVariable int id, @RequestBody Contact contact){
			Contact contactUpdated = contactJpaRepository.save(contact);
			return ResponseEntity.accepted().build();
	}
	@DeleteMapping("/jpa/delete/{id}")
	public ResponseEntity<Void> deleteContact(
		@PathVariable long id){
			contactJpaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
	}
}
