package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Repositories.InvestorRepository;
import com.InvestWithIntelligence.Services.InvestorServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

@Service
public class InvestorServiceImpl implements InvestorServices {

    @Autowired
    private InvestorRepository investorRepository;
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

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
            throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
        }
        return this.investorRepository.findById(id);
    }

    @Override
    public Investor addAccount(Investor investorModel) {
        try {
            if (investorRepository == null) {
                throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
            }
            if (investorRepository.existsByUsername(investorModel.getUsername())) {
                throw new IllegalArgumentException(IwIConstants.USERNAME_EXISTS);
            }
            if (investorRepository.existsByEmail(investorModel.getEmail())) {
                throw new IllegalArgumentException(IwIConstants.EMAIL_EXISTS);
            }
            return this.investorRepository.save(investorModel);
        } catch (Exception ex) {

            logger.error("Error in register Admin", ex);
            throw ex;
        }

    }

    @Override
    public List<Investor> fetchAll() {
        return this.investorRepository.findAll();
    }

}
