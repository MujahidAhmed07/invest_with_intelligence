package com.InvestWithIntelligence.Services;

import java.util.List;
import java.util.Optional;

import com.InvestWithIntelligence.Models.Investor;

public interface InvestorServices {

    Investor findByUsername(String username);

    Investor findByEmail(String email);

    Optional<Investor> findById(Long id);

    Investor addAccount(Investor investorModel);

    List<Investor> fetchAll();

    void deleteById(Long id);

}
