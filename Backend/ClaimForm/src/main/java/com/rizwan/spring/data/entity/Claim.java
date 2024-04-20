package com.rizwan.spring.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Random;

@Entity
@Table(name="ClaimDetails")
public class Claim {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String claimantName;
    private String email;
    private String phoneNumber;
    private String description;
    private String policyNumber;
    private String claimNumber; // Claim number will be generated automatically
    private String status = "pending"; // Default status is "pending"
    
    private static final Random RANDOM = new Random();

    public Claim() {
        // Generate claim number automatically
        this.claimNumber = generateClaimNumber();
    }

    public Claim(Long id, String claimantName, String email, String phoneNumber, String description,
                 String policyNumber) {
        this.id = id;
        this.claimantName = claimantName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.policyNumber = policyNumber;
        this.claimNumber = generateClaimNumber(); // Ensure claim number is always generated automatically
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimantName() {
        return claimantName;
    }

    public void setClaimantName(String claimantName) {
        this.claimantName = claimantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String generateClaimNumber() {
        String prefix = "C";
        String digits = generateRandomDigits(4);
        return prefix + digits;
    }

    private String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt(10)); // Generate a random digit between 0 and 9
        }
        return sb.toString();
    }
}
