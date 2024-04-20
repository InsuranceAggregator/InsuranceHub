package com.rizwan.spring.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rizwan.spring.data.entity.Claim;
import com.rizwan.spring.data.repository.ClaimRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public Claim submitClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim getClaimById(Long id) {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        return optionalClaim.orElse(null);
    }


    public Claim updateClaim(Long id, Claim claimDetails) {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            Claim existingClaim = optionalClaim.get();
            existingClaim.setClaimantName(claimDetails.getClaimantName());
            existingClaim.setEmail(claimDetails.getEmail());
            existingClaim.setPhoneNumber(claimDetails.getPhoneNumber());
            existingClaim.setDescription(claimDetails.getDescription());
            return claimRepository.save(existingClaim);
        } else {
            return null;
        }
    }


    public boolean deleteClaim(Long id) {
        Optional<Claim> optionalClaim = claimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            claimRepository.delete(optionalClaim.get());
            return true;
        } else {
            return false;
        }
    }
}
