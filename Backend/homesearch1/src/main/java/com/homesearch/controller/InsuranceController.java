
package com.homesearch.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.homesearch.entity.Insurance;

import com.homesearch.service.InsuranceService;
 
@RestController

@RequestMapping("/insurance")

public class InsuranceController {
 
    private final InsuranceService insuranceService;
 
    @Autowired

    public InsuranceController(InsuranceService insuranceService) {

        this.insuranceService = insuranceService;

    }
 
    @GetMapping("/plans")

    public List<Insurance> getAllPlans() {

        return insuranceService.getAllPlans();

    }
 
    @PostMapping("/plans")

    public Insurance createPlan(@RequestBody Insurance plan) {

        return insuranceService.createPlan(plan);

    }
 
    @GetMapping("/plans/{id}")

    public Insurance getPlanById(@PathVariable Long id) {

        return insuranceService.getPlanById(id);

    }
 
    @PutMapping("/plans/{id}")
    public ResponseEntity<Insurance> updatePlan(@PathVariable Long id, @RequestBody Insurance planDetails) {
        Insurance updatedPlan = insuranceService.updatePlan(id, planDetails);
        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/plans/{id}")

    public void deletePlan(@PathVariable Long id) {

        insuranceService.deletePlan(id);

    }
 
    // New endpoint for searching by policy name

    @GetMapping("/plans/search")

    public List<Insurance> searchPlansByPolicyName(@RequestParam String policyName) {

        return insuranceService.searchPlansByPolicyName(policyName);

    }

}
