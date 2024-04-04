package com.insurance.abcd.model;

//import javax.persistence.Entity;
//import javax.persistence.Id;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Component
@Entity

@Table(name="Userdetails")
public class UserProfile {
 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String email;
	private String name;
	private String mobilenumber;
	private String address;
	private String description;
	// get put-- save, update post
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserProfile(int id, String email, String name, String mobilenumber, String address, String description) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.mobilenumber = mobilenumber;
		this.address = address;
		this.description = description;
	}
	public UserProfile() {
	
	}
}