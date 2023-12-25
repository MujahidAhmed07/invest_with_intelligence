package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Repositories.InvestorRepository;
import com.InvestWithIntelligence.Services.InvestorServices;
import com.InvestWithIntelligence.Utils.AppConstants;

@Service
public class InvestorServiceImpl implements InvestorServices {

    private InvestorRepository investorRepository;

    @Override
    public Investor findByUsername(String username) {
        return this.investorRepository.findByUsername(username);
    }

    @Override
    public Investor findByEmail(String email) {
        return this.investorRepository.findByEmail(email);
    }

    @Override
    public Optional<Investor> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(AppConstants.ID_VALIDATION);
        }
        return this.investorRepository.findById(id);
    }

    @Override
    public Investor addAccount(Investor investorModel) {
        return this.investorRepository.save(investorModel);
    }

    @Override
    public List<Investor> fetchAll() {
        return this.investorRepository.findAll();
    }

}
