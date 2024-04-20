package com.rizwan.spring.data.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="policy_holder")
public class Policy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String mobileNumber;
    private int age;
    private String gender;
    private String policyNumber;
    private String policyType;
    private double amount;
    private LocalDate startDate;
    private LocalDate endDate;
    // Constructors
    public Policy() {
    }
	public Policy(Long id, String name, String email, String mobileNumber, int age, String gender, String policyNumber,
			String policyType, double amount, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.age = age;
		this.gender = gender;
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.amount = amount;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + ", age="
				+ age + ", gender=" + gender + ", policyNumber=" + policyNumber + ", policyType=" + policyType
				+ ", amount=" + amount + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
    
}
   
