package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Entreprenuer;
import com.InvestWithIntelligence.Repositories.EntreprenuerRepository;
import com.InvestWithIntelligence.Services.EntreprenuerServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

@Service
public class EntreprenuerServiceImpl implements EntreprenuerServices {

    @Autowired
    private EntreprenuerRepository entreprenuerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(EntreprenuerServiceImpl.class);

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

        entreprenuerModel.setPassword(passwordEncoder.encode(entreprenuerModel.getPassword()));
        return this.entreprenuerRepository.save(entreprenuerModel);
    }

    @Override
    public List<Entreprenuer> fetchAll() {
        return this.entreprenuerRepository.findAllCustomQuery();
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
            }
            this.entreprenuerRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error in Delete Entreprenuer");
            e.printStackTrace();
        }
    }

    @Override
    public Entreprenuer fetchByEmailByRole(String email) {
        return this.entreprenuerRepository.findByRole(email);
    }

    @Override
    public Entreprenuer findByCustomEmail(String email) {
        return this.entreprenuerRepository.findByCustomEmail(email);
    }
}