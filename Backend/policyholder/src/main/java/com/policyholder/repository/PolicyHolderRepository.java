package com.policyholder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policyholder.entity.PolicyHolder;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Long> {

}
