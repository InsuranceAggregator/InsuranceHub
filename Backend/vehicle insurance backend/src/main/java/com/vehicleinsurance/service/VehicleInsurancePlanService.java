package com.vehicleinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicleinsurance.entity.VehicleInsurancePlan;
import com.vehicleinsurance.repository.VehicleInsurancePlanRepository;

@Service
public class VehicleInsurancePlanService {

    private final VehicleInsurancePlanRepository vehicleInsurancePlanRepository;

    @Autowired
    public VehicleInsurancePlanService(VehicleInsurancePlanRepository vehicleInsurancePlanRepository) {
        this.vehicleInsurancePlanRepository = vehicleInsurancePlanRepository;
    }

    public List<VehicleInsurancePlan> getAllPlans() {
        return vehicleInsurancePlanRepository.findAll();
    }

    public VehicleInsurancePlan createPlan(VehicleInsurancePlan plan) {
        return vehicleInsurancePlanRepository.save(plan);
    }

    public VehicleInsurancePlan getPlanById(Long id) {
        return vehicleInsurancePlanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));
    }

    public VehicleInsurancePlan updatePlan(Long id, VehicleInsurancePlan planDetails) {
    	VehicleInsurancePlan plan = vehicleInsurancePlanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));

        plan.setPolicyNumber(planDetails.getPolicyNumber());
        plan.setVehicleType(planDetails.getVehicleType());
        plan.setVehicleRegistrationNumber(planDetails.getVehicleRegistrationNumber());
        plan.setVehicleModel(planDetails.getVehicleModel());
       
        return vehicleInsurancePlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        vehicleInsurancePlanRepository.deleteById(id);
    }

	public VehicleInsurancePlan postVehicledata(VehicleInsurancePlan plan) {
		// TODO Auto-generated method stub
		 return vehicleInsurancePlanRepository.save(plan);
	}
}
