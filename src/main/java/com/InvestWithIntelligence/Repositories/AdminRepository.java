package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    public Admin findByEmail(String email);

    public Admin findByUsernameIgnoreCase(String username);

    boolean existsByEmailIgnoreCase(String email);

    boolean existsByUsernameIgnoreCase(String username);

}
