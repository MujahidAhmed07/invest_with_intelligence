package com.InvestWithIntelligence.Services;

import java.util.Optional;

import com.InvestWithIntelligence.Models.Admin;

public interface AdminServices {

    Admin findByEmail(String email);

    Admin addAccount(Admin adminModel);

    Admin findByUsername(String username);

    Optional<Admin> findById(Long id);

}
