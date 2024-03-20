package com.vehicleinsurance.entity;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class VehicleInsurancePlan {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String vehicleType;
    private String vehicleRegistrationNumber;
    private String vehicleModel;

	public VehicleInsurancePlan() {
        // Default constructor with default values
    	
		this.policyNumber = "1111";
		this.vehicleType = "Car";
		this.vehicleRegistrationNumber = "KA05MG9102";
		this.vehicleModel = "BMW X3";
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


	public String getVehicleRegistrationNumber() {
		return vehicleRegistrationNumber;
	}


	public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) {
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
	}


	public String getVehicleType() {
		return vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}


	public String getVehicleModel() {
		return vehicleModel;
	}


	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	
    public VehicleInsurancePlan(Long id, String policyNumber, String vehicleType, String vehicleRegistrationNumber, String vehicleModel) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.vehicleType = vehicleType;
		this.vehicleRegistrationNumber = vehicleRegistrationNumber;
		this.vehicleModel = vehicleModel;
	}


}
	