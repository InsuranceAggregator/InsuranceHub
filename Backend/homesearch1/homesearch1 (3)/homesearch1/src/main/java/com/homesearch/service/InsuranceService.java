package com.homesearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homesearch.entity.Insurance;
import com.homesearch.repository.InsuranceRepository;

@Service
public class InsuranceService {
 
    private final InsuranceRepository insuranceRepository;
 
    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }
 
    public List<Insurance> getAllPlans() {
        return insuranceRepository.findAll();
    }
 
    public Insurance createPlan(Insurance plan) {
        // Set policy number and policy name before saving
        // Assuming these fields are present in the Insurance entity class
        plan.setPolicyNumber(plan.getPolicyNumber());
        plan.setPolicyName(plan.getPolicyName());
        return insuranceRepository.save(plan);
    }
 
    public Insurance getPlanById(Long id) {
        return insuranceRepository.findById(id).orElse(null);
    }
 
    public Insurance updatePlan(Long id, Insurance planDetails) {
        // Check if the plan exists
        Insurance existingPlan = insuranceRepository.findById(id).orElse(null);
        if (existingPlan != null) {
            // Update plan details
            existingPlan.setPolicyName(planDetails.getPolicyName());
            // Set other fields as needed
            return insuranceRepository.save(existingPlan);
        }
        return null; // Return null if the plan doesn't exist
    }
 
    public void deletePlan(Long id) {
        insuranceRepository.deleteById(id);
    }
 
    // Method to search plans by policy name
    public List<Insurance> searchPlansByPolicyName(String policyName) {
        return insuranceRepository.findByPolicyName(policyName);
    }
}

