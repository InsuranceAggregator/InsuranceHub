package com.rizwan.spring.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rizwan.spring.data.model.ExistingClaim;
import com.rizwan.spring.data.repository.ExistingClaimRepository;
import java.util.List;

@Service
public class ExistingClaimService {

    @Autowired
    private ExistingClaimRepository existingClaimRepository;

    public List<ExistingClaim> getClaimsByEmail(String email) {
        return existingClaimRepository.findByEmail(email);
    }

    // Other service methods can be added here based on your application requirements
}
