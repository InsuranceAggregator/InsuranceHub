package com.homesearch.repository;
 
import java.util.List;
 
import org.springframework.data.jpa.repository.JpaRepository;
import com.homesearch.entity.Insurance;
 
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    List<Insurance> findByPolicyName(String policyName);
}