package com.vehicleinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicleinsurance.entity.VehicleInsurancePlan;

public interface VehicleInsurancePlanRepository extends JpaRepository<VehicleInsurancePlan, Long>  {

}
