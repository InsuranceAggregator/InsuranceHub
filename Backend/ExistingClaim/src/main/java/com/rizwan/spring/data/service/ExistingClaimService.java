package com.rizwan.spring.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rizwan.spring.data.model.ExistingClaim;
import com.rizwan.spring.data.repository.ExistingClaimRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExistingClaimService {

    @Autowired
    private ExistingClaimRepository existingClaimRepository;

    public List<ExistingClaim> getClaimsByEmail(String email) {
        return existingClaimRepository.findByEmail(email);
    }
    
    
    public List<ExistingClaim> getAllExistingClaims() {
        return existingClaimRepository.findAll();
    }
    
    public List<ExistingClaim> updateClaimByClaimNumber(String claimNumber, ExistingClaim updatedClaim) {
        List<ExistingClaim> existingClaims = existingClaimRepository.findByClaimNumber(claimNumber);
        List<ExistingClaim> updatedClaims = new ArrayList<>();

        for (ExistingClaim existingClaim : existingClaims) {
            // Update the fields of each existing claim with the values from updatedClaim
            existingClaim.setClaimantName(updatedClaim.getClaimantName());
            existingClaim.setPhoneNumber(updatedClaim.getPhoneNumber());
            existingClaim.setDescription(updatedClaim.getDescription());
            existingClaim.setPolicyNumber(updatedClaim.getPolicyNumber());
            existingClaim.setStatus(updatedClaim.getStatus());
            // Save the updated claim
            updatedClaims.add(existingClaimRepository.save(existingClaim));
        }

        return updatedClaims;
    }

    // Other service methods can be added here based on your application requirements
}
