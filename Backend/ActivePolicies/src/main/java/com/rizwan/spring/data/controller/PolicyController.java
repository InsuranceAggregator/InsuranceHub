package com.rizwan.spring.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rizwan.spring.data.model.Policy;
import com.rizwan.spring.data.service.PolicyService;

import java.util.List;

@RestController
@RequestMapping("/policies")

public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @GetMapping("/active/{email}")
    public List<Policy> getPoliciesByEmail(@PathVariable String email) {
        return policyService.getPoliciesByEmail(email);
    }

    // Other controller methods can be added here based on your application requirements
}

