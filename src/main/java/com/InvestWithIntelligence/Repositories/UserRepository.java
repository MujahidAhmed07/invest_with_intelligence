package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InvestWithIntelligence.Models.Admin;

public interface UserRepository extends JpaRepository<Admin, String> {

}
