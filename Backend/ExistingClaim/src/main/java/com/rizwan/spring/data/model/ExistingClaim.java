package com.rizwan.spring.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ClaimDetails")
public class ExistingClaim {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    
    private String claimantName;
    private String email;
    private String phoneNumber;
    private String description;
    private String policyNumber;
    private String claimNumber; 
    private String status;
    
    // Constructors
    public ExistingClaim() {
    }

	public ExistingClaim(Long id, String claimantName, String email, String phoneNumber, String description,
			String policyNumber, String claimNumber, String status) {
		super();
		this.id = id;
		this.claimantName = claimantName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.policyNumber = policyNumber;
		this.claimNumber = claimNumber;
		this.status = status;
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

	@Override
	public String toString() {
		return "ExistingClaim [id=" + id + ", claimantName=" + claimantName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", description=" + description + ", policyNumber=" + policyNumber + ", claimNumber="
				+ claimNumber + ", status=" + status + "]";
	}
	
}
   
