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
public class ContactsResource {
	
	@Autowired
	private ContactsHardcodedService contactService;
	
	@GetMapping("/contacts")
	public List<Contact> getAllContacts(String Id){
		return contactService.findAll();
	}
	@PostMapping("/add")
	public ResponseEntity<Void> saveContact( @RequestBody Contact contact){
			Contact contactAdded = contactService.save(contact);
			return ResponseEntity.accepted().build();
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Contact> updateContact(
		@PathVariable int id, @RequestBody Contact contact){
			Contact contactUpdated = contactService.save(contact);
			return ResponseEntity.accepted().build();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteContact(
		@PathVariable long id){
			Contact contact = contactService.deleteById(id);
			if(contact!=null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
	}
}
