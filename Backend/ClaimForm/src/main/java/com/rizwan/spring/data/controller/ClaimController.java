package com.rizwan.spring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rizwan.spring.data.entity.Claim;
import com.rizwan.spring.data.service.ClaimService;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping("/claims")
    public ResponseEntity<Claim> submitClaim(@RequestBody Claim claim) {
        Claim submittedClaim = claimService.submitClaim(claim);
        return new ResponseEntity<>(submittedClaim, HttpStatus.CREATED);
    }

    @GetMapping("/claims")
    public ResponseEntity<List<Claim>> getAllClaims() {
        List<Claim> claims = claimService.getAllClaims();
        return new ResponseEntity<>(claims, HttpStatus.OK);
    }

    @GetMapping("/claims/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable Long id) {
        Claim claim = claimService.getClaimById(id);
        if (claim != null) {
            return new ResponseEntity<>(claim, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/claims/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable Long id, @RequestBody Claim claimDetails) {
        Claim updatedClaim = claimService.updateClaim(id, claimDetails);
        if (updatedClaim != null) {
            return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/claims/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        boolean deleted = claimService.deleteClaim(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

