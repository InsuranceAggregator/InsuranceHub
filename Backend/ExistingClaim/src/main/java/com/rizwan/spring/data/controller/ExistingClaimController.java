package com.rizwan.spring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rizwan.spring.data.model.ExistingClaim;
import com.rizwan.spring.data.service.ExistingClaimService;
import java.util.List;

@RestController
@RequestMapping("/claims")
@CrossOrigin(origins="http://localhost:4200")
public class ExistingClaimController {

    @Autowired
    private ExistingClaimService existingClaimService;

    @GetMapping("/existing/{email}")
    public List<ExistingClaim> getClaimsByEmail(@PathVariable String email) {
        return existingClaimService.getClaimsByEmail(email);
    }

    // Other controller methods can be added here based on your application requirements
}

