package com.policyholder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.Random;

@Entity
public class PolicyHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String mobileNumber;
    private int age;
    private String gender;
    private String policyNumber; // Policy number will be generated automatically
    private String policyType;
    private double premium;
    private LocalDate startDate;
    private LocalDate endDate;

    private static final Random RANDOM = new Random();

    public PolicyHolder() {
        // Generate policy number automatically
        this.policyNumber = generatePolicyNumber();
    }

    // Constructor with all fields

    public PolicyHolder(Long id, String name, String email, String mobileNumber, int age, String gender,
                        String policyType, double premium, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
        this.policyNumber = generatePolicyNumber(); // Ensure policy number is always generated automatically
        this.policyType = policyType;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    // Setter for policyNumber is omitted to ensure it's generated automatically

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Generate a policy number with "P" followed by four random digits

    private String generatePolicyNumber() {
        String prefix = "P";
        String digits = generateRandomDigits(4);
        return prefix + digits;
    }

    // Generate a string of random digits with the specified length

    private String generateRandomDigits(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(RANDOM.nextInt(10)); // Generate a random digit between 0 and 9
        }
        return sb.toString();
    }
}
