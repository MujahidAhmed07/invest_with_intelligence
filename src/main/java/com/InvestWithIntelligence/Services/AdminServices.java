package com.InvestWithIntelligence.Services;

import java.util.Optional;

import com.InvestWithIntelligence.Models.Admin;

import jakarta.validation.Valid;

public interface AdminServices {

    Admin findByEmail(String email);

    Admin addAccount(Admin adminModel);

    Admin findByUsername(String username);

    Optional<Admin> findById(Long id);

    Admin updateAccount(Admin adminModel, Long id);

    boolean deleteAccount(@Valid Long id);

}
