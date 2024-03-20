package com.vehicleinsurance.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.vehicleinsurance.entity.VehicleInsurancePlan;
import com.vehicleinsurance.service.VehicleInsurancePlanService;
import com.vehicleinsurance.service.NotFoundException; // Add this import
 
@RestController
@RequestMapping("/vehicle-insurance/plans")
@CrossOrigin("*")
public class VehicleInsuranceController {
	@Autowired
    private final VehicleInsurancePlanService vehicleInsurancePlanService;
 
    
    public VehicleInsuranceController(VehicleInsurancePlanService vehicleInsurancePlanService) {
        this.vehicleInsurancePlanService = vehicleInsurancePlanService;
    }
 
    @GetMapping
    public List<VehicleInsurancePlan> getAllPlans() {
        return vehicleInsurancePlanService.getAllPlans();
    }
 
    @PostMapping
    public VehicleInsurancePlan postVehicledata(@RequestBody VehicleInsurancePlan plan) {
        return vehicleInsurancePlanService.postVehicledata(plan);
    }
 
    @GetMapping("/{id}")
    public VehicleInsurancePlan getPlanById(@PathVariable Long id) {
        return vehicleInsurancePlanService.getPlanById(id);
    }
 
    @PutMapping("/{id}")
    public VehicleInsurancePlan updatePlan(@PathVariable Long id, @RequestBody VehicleInsurancePlan planDetails) {
        return vehicleInsurancePlanService.updatePlan(id, planDetails);
    }
 
    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
    	vehicleInsurancePlanService.deletePlan(id);
    }
    
    // Add exception handler for NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
