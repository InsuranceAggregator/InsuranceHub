package com.policyholder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.policyholder.entity.PolicyHolder;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, Long> {

	PolicyHolder findByEmail(String email);

	List<PolicyHolder> findAllByEmail(String email);

}
