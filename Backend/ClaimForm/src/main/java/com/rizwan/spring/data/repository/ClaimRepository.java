package com.rizwan.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rizwan.spring.data.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    // Add custom query methods if needed
}

