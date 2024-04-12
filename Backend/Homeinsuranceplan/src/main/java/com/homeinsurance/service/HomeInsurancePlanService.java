package com.homeinsurance.service;

	import java.util.List;
	 
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	 
	import com.homeinsurance.entity.HomeInsurancePlan;
	import com.homeinsurance.repository.HomeInsurancePlanRepository;
	 
	@Service
	public class HomeInsurancePlanService {
	 
		private final HomeInsurancePlanRepository homeInsurancePlanRepository;
	 
	    @Autowired
	    public HomeInsurancePlanService(HomeInsurancePlanRepository homeInsurancePlanRepository) {
	        this.homeInsurancePlanRepository = homeInsurancePlanRepository;
	    }
	    public List<HomeInsurancePlan> getAllPlans() {
	        return homeInsurancePlanRepository.findAll();
	    }
	 
	    public HomeInsurancePlan createPlan(HomeInsurancePlan plan) {
	        return homeInsurancePlanRepository.save(plan);
	    }
	 
	    public HomeInsurancePlan getPlanById(Long id) {
	        return homeInsurancePlanRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));
	    }
	 
	    public HomeInsurancePlan updatePlan(Long id, HomeInsurancePlan planDetails) {
	        HomeInsurancePlan plan = homeInsurancePlanRepository.findById(id)
	                .orElseThrow(() -> new NotFoundException("Plan not found with id " + id));
	       

	            // Method to map planDetails fields to HomeInsurance fields
	            
	                plan.setPolicyNumber(planDetails.getPolicyNumber());
	                plan.setType(planDetails.getType());
	                plan.setPremium(planDetails.getPremium());
	                plan.setStatus(planDetails.getStatus());
	            
	        

	       
	        return homeInsurancePlanRepository.save(plan);
	    }
	 
	    public void deletePlan(Long id) {
	        if (!homeInsurancePlanRepository.existsById(id)) {
	            throw new NotFoundException("Plan not found with id " + id);
	        }
	        homeInsurancePlanRepository.deleteById(id);
	    }
	}

