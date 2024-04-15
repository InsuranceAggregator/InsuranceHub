package com.contactus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactus.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
