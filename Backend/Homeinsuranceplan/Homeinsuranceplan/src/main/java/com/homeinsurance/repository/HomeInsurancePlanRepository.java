package com.homeinsurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeinsurance.entity.HomeInsurancePlan;
 
 
public interface HomeInsurancePlanRepository extends JpaRepository<HomeInsurancePlan, Long>   {
 
}