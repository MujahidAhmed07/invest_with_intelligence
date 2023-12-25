package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Entreprenuer;
import com.InvestWithIntelligence.Repositories.EntreprenuerRepository;
import com.InvestWithIntelligence.Services.EntreprenuerServices;
import com.InvestWithIntelligence.Utils.AppConstants;

@Service
public class EntreprenuerServiceImpl implements EntreprenuerServices {

    @Autowired
    private EntreprenuerRepository entreprenuerRepository;

    @Override
    public Entreprenuer findByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException(AppConstants.EMAIL_VALIDATION);
        }
        return this.entreprenuerRepository.findByUsername(username);
    }

    @Override
    public Entreprenuer findByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException(AppConstants.EMAIL_VALIDATION);
        }
        return this.entreprenuerRepository.findByEmail(email);
    }

    @Override
    public Optional<Entreprenuer> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(AppConstants.ID_VALIDATION);
        }
        return this.entreprenuerRepository.findById(id);
    }

    @Override
    public Entreprenuer addAccount(Entreprenuer entreprenuerModel) {
        if (entreprenuerModel == null) {
            throw new IllegalArgumentException(AppConstants.OBJ_NOT_NULL);
        }
        return this.entreprenuerRepository.save(entreprenuerModel);
    }

    @Override
    public List<Entreprenuer> fetchAll() {
        return this.entreprenuerRepository.findAll();
    }
}