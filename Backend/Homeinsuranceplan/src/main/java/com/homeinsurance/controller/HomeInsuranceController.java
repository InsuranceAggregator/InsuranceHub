package com.homeinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.homeinsurance.entity.HomeInsurancePlan;
import com.homeinsurance.service.HomeInsurancePlanService;
import com.homeinsurance.service.NotFoundException;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/home-insurance/plans")
@CrossOrigin(origins="http://localhost:4200")
public class HomeInsuranceController {
 
    private final HomeInsurancePlanService homeInsurancePlanService;
 
    @Autowired
    public HomeInsuranceController(HomeInsurancePlanService homeInsurancePlanService) {
        this.homeInsurancePlanService = homeInsurancePlanService;
    }
 
    @GetMapping
    public ResponseEntity<List<HomeInsurancePlan>> getAllPlans() {
        try {
            List<HomeInsurancePlan> plans = homeInsurancePlanService.getAllPlans();
            return new ResponseEntity<>(plans, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @PostMapping
    
    public ResponseEntity<HomeInsurancePlan> createPlan(@Valid @RequestBody HomeInsurancePlan plan) {
        try {
         HomeInsurancePlan createdPlan = homeInsurancePlanService.createPlan(plan);
            return new ResponseEntity<>(createdPlan, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<HomeInsurancePlan> getPlanById(@PathVariable Long id) {
        try {
            HomeInsurancePlan plan = homeInsurancePlanService.getPlanById(id);
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<HomeInsurancePlan> updatePlan(@PathVariable Long id, @RequestBody HomeInsurancePlan planDetails) {
        try {
            HomeInsurancePlan updatedPlan = homeInsurancePlanService.updatePlan(id, planDetails);
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        try {
            homeInsurancePlanService.deletePlan(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
 
 
}