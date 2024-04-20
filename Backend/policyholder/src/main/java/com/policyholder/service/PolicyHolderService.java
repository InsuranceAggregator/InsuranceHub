package com.policyholder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.policyholder.entity.PolicyHolder;
import com.policyholder.repository.PolicyHolderRepository;

@Service
public class PolicyHolderService {

    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    public List<PolicyHolder> getAllPolicyHolders() {
        return policyHolderRepository.findAll();
    }

    public PolicyHolder getPolicyHolderById(Long id) {
        return policyHolderRepository.findById(id).orElse(null);
    }

    public PolicyHolder savePolicyHolder(PolicyHolder policyHolder) {
        return policyHolderRepository.save(policyHolder);
    }

    public void deletePolicyHolder(Long id) {
        policyHolderRepository.deleteById(id);
    }

    public List<String> getPolicyNumbersByEmail(String email) {
        // Retrieve all policy holders by email
        List<PolicyHolder> policyHolders = policyHolderRepository.findAllByEmail(email);

        // Extract policy numbers from all policy holders
        List<String> policyNumbers = new ArrayList<>();
        for (PolicyHolder policyHolder : policyHolders) {
            if (policyHolder.getPolicyNumber() != null) {
                policyNumbers.add(policyHolder.getPolicyNumber());
            }
        }
        
        return policyNumbers;
    }

}
