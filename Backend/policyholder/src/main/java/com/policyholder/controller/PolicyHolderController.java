
package com.policyholder.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
 
import com.policyholder.entity.PolicyHolder;

import com.policyholder.service.PolicyHolderService;
 
@RestController

@RequestMapping("/policyholders")

@CrossOrigin(origins="http://localhost:4200")

public class PolicyHolderController {

	@Autowired

    private PolicyHolderService policyHolderService;
 
    @GetMapping("/")

    public List<PolicyHolder> getAllPolicyHolders() {

        return policyHolderService.getAllPolicyHolders();

    }
 
    @GetMapping("/{id}")

    public PolicyHolder getPolicyHolderById(@PathVariable Long id) {

        return policyHolderService.getPolicyHolderById(id);

    }
 
    @PostMapping("/")

    public PolicyHolder addPolicyHolder(@RequestBody PolicyHolder policyHolder) {

        return policyHolderService.savePolicyHolder(policyHolder);

    }
 
    @PutMapping("/{id}")

    public PolicyHolder updatePolicyHolder(@PathVariable Long id, @RequestBody PolicyHolder policyHolder) {

        policyHolder.setId(id);

        return policyHolderService.savePolicyHolder(policyHolder);

    }
 
    @DeleteMapping("/{id}")

    public void deletePolicyHolder(@PathVariable Long id) {

        policyHolderService.deletePolicyHolder(id);

    }
    @GetMapping("/{email}/policies")
    public List<String> getPolicyNumbersByEmail(@PathVariable String email) {
        return policyHolderService.getPolicyNumbersByEmail(email);
    }

}
