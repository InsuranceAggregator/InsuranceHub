package com.rizwan.spring.data.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rizwan.spring.data.model.ExistingClaim;

public interface ExistingClaimRepository extends JpaRepository<ExistingClaim, Long> {
	List<ExistingClaim> findByEmail(String email);
}
