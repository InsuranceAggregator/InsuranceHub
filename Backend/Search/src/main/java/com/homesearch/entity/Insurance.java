
package com.homesearch.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Insurance {
 
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String policyNumber;

    private String policyName;

    private String description;

    private Double premium;
    private String policyType;
    
 
    // Constructors, getters, and setters
 
    public Insurance() {

    }
 
    public Insurance(String policyNumber, String policyName, String description, Double premium) {

        this.policyNumber = policyNumber;

        this.policyName = policyName;
        this.policyType = policyType;

        this.description = description;

        this.premium = premium;

    }
 
    public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Long getId() {

        return id;

    }
 
    public void setId(Long id) {

        this.id = id;

    }
 
    public String getPolicyNumber() {

        return policyNumber;

    }
 
    public void setPolicyNumber(String policyNumber) {

        this.policyNumber = policyNumber;

    }
 
    public String getPolicyName() {

        return policyName;

    }
 
    public void setPolicyName(String policyName) {

        this.policyName = policyName;

    }
 
    public String getDescription() {

        return description;

    }
 
    public void setDescription(String description) {

        this.description = description;

    }
 
    public Double getPremium() {

        return premium;

    }
 
    public void setPremium(Double premium) {

        this.premium = premium;

    }

}
