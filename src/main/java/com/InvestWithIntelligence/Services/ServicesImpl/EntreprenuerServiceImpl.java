package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Entreprenuer;
import com.InvestWithIntelligence.Repositories.EntreprenuerRepository;
import com.InvestWithIntelligence.Services.EntreprenuerServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

@Service
public class EntreprenuerServiceImpl implements EntreprenuerServices {

    @Autowired
    private EntreprenuerRepository entreprenuerRepository;

    @Override
    public Entreprenuer findByUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException(IwIConstants.EMAIL_VALIDATION);
        }
        return this.entreprenuerRepository.findByUsername(username);
    }

    @Override
    public Entreprenuer findByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException(IwIConstants.EMAIL_VALIDATION);
        }
        return this.entreprenuerRepository.findByEmail(email);
    }

    @Override
    public Optional<Entreprenuer> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
        }
        return this.entreprenuerRepository.findById(id);
    }

    @Override
    public Entreprenuer addAccount(Entreprenuer entreprenuerModel) {
        if (entreprenuerModel == null) {
            throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
        }
        if (entreprenuerRepository.existsByUsername(entreprenuerModel.getUsername())) {
            throw new IllegalArgumentException(IwIConstants.USERNAME_EXISTS);
        }
        if (entreprenuerRepository.existsByEmail(entreprenuerModel.getEmail())) {
            throw new IllegalArgumentException(IwIConstants.EMAIL_EXISTS);
        }

        return this.entreprenuerRepository.save(entreprenuerModel);
    }

    @Override
    public List<Entreprenuer> fetchAll() {
        return this.entreprenuerRepository.findAllCustomQuery();
    }
}