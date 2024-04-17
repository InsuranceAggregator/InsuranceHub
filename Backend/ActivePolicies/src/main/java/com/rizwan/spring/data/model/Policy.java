package com.rizwan.spring.data.model;

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
    private double premium;
    
    // Constructors
    public Policy() {
    }
    
    public Policy(String name, String email, String mobileNumber, int age, String gender, String policyNumber, String policyType, double premium) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.premium = premium;
    }
    
    // Getters and Setters
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

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }
    
    // toString method
    @Override
    public String toString() {
        return "InsurancePolicy [id=" + id + ", name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber
                + ", age=" + age + ", gender=" + gender + ", policyNumber=" + policyNumber + ", policyType="
                + policyType + ", premium=" + premium + "]";
    }
}