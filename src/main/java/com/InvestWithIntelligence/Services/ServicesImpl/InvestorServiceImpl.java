package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Models.InvestorMetadata;
import com.InvestWithIntelligence.Repositories.InvestorRepository;
import com.InvestWithIntelligence.Services.InvestorServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

@Service
public class InvestorServiceImpl implements InvestorServices {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private InvestorRepository investorRepository;
    private static final Logger logger = LoggerFactory.getLogger(InvestorServiceImpl.class);

    @Override
    public Investor findByUsername(String username) {
        return this.investorRepository.findByUsername(username);
    }

    @Override
    public Investor findByEmail(String email) {
        return this.investorRepository.findByCustomEmail(email);
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
            investorModel.setPassword(passwordEncoder.encode(investorModel.getPassword()));
            return this.investorRepository.save(investorModel);
        } catch (Exception ex) {

            logger.error("Error in register Investor", ex);
            throw ex;
        }

    }

    @Override
    public List<Investor> fetchAll() {
        return this.investorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
            }
            this.investorRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error in Delete Investor");
            e.printStackTrace();
        }
    }

    @Override
    public Investor updateByEmail(String email, Investor updatedInvestor) {
        // Retrieve existing investor data from the repository based on email
        Investor existingInvestor = investorRepository.findByEmail(email);

        // Update password
        existingInvestor.setPassword(updatedInvestor.getPassword());

        // Update InvestorMetadata fields
        InvestorMetadata updatedMetadata = updatedInvestor.getInvestorMetadata();
        InvestorMetadata existingMetadata = existingInvestor.getInvestorMetadata();

        existingMetadata.setFname(updatedMetadata.getFname());
        existingMetadata.setLname(updatedMetadata.getLname());
        existingMetadata.setContact(updatedMetadata.getContact());
        existingMetadata.setCity(updatedMetadata.getCity());
        existingMetadata.setDescription(updatedMetadata.getDescription());
        existingMetadata.setAddress(updatedMetadata.getAddress());

        // Save the updated investor data back to the repository
        return investorRepository.save(existingInvestor);
    }

}
