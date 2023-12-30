package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

    Investor findByUsername(String username);

    Investor findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
