
package com.homesearch.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.homesearch.entity.Insurance;

import com.homesearch.service.InsuranceService;
 
@RestController

@RequestMapping("/insurance")
@CrossOrigin("*")
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

    public Insurance updatePlan(@PathVariable Long id, @RequestBody Insurance planDetails) {

        return insuranceService.updatePlan(id, planDetails);

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
