package com.homeinsurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Pattern;



@Entity
public class HomeInsurancePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Policy number must contain only alphabetic or numeric characters")
    private String policyNumber;

    private String type;
    private Double premium;

    
    @Pattern(regexp = "^(Active|Pending|Cancelled|InProgress)$", message = "Status must be one of: Active, Pending, Cancelled, InProgress")
    private String status;

    // Default constructor
    public HomeInsurancePlan() {
        // No default values assigned here
    }

    // Constructor with parameters
    public HomeInsurancePlan(String policyNumber, String type, Double premium, String status) {
        this.policyNumber = policyNumber;
        this.type = type;
        this.premium = premium;
        this.status = status;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPremium() {
		return premium;
	}

	public void setPremium(Double premium) {
		this.premium = premium;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HomeInsurancePlan(Long id,
			@Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Policy number must contain only alphabetic or numeric characters") String policyNumber,
			String type, Double premium,
			@Pattern(regexp = "^(Active|Pending|Cancelled|InProgress)$", message = "Status must be one of: Active, Pending, Cancelled, InProgress") String status) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.type = type;
		this.premium = premium;
		this.status = status;
	}
    


    // Getters and Setters...
}
