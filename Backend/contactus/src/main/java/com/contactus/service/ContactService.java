package com.contactus.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.contactus.entity.Contact;

public interface ContactService {
	    Contact addContact(Contact contact);
	    List<Contact> getAllContacts();
	    ResponseEntity<Contact> getContactById(Long id);
	    ResponseEntity<Contact> updateContact(Long id, Contact newContact);
	    ResponseEntity<Void> deleteContact(Long id);
	
}
