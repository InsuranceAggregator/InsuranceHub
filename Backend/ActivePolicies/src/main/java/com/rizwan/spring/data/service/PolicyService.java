package com.rizwan.spring.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rizwan.spring.data.model.Policy;
import com.rizwan.spring.data.repository.PolicyRepository;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public List<Policy> getPoliciesByEmail(String email) {
        return policyRepository.findByEmail(email);
    }

    // Other service methods can be added here based on your application requirements
}
