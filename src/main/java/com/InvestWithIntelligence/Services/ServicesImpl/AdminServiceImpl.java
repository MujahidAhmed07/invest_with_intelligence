package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Repositories.AdminRepository;
import com.InvestWithIntelligence.Services.AdminServices;
import com.InvestWithIntelligence.Utils.AppConstants;

@Service
public class AdminServiceImpl implements AdminServices {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException(AppConstants.EMAIL_VALIDATION);
        }
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin addAccount(Admin adminModel) {
        try {

            if (adminModel == null) {
                throw new IllegalArgumentException(AppConstants.OBJ_NOT_NULL);
            }
            if (adminRepository.existsByUsername(adminModel.getUsername())) {
                throw new IllegalArgumentException(AppConstants.USERNAME_EXISTS);
            }
            if (adminRepository.existsByEmail(adminModel.getEmail())) {
                throw new IllegalArgumentException(AppConstants.EMAIL_EXISTS);
            }
            return this.adminRepository.save(adminModel);
        } catch (Exception ex) {

            logger.error("Error in register Admin", ex);
            throw ex;
        }
    }

    @Override
    public Admin findByUsername(String username) {
        try {
            if (username == null || username.isEmpty()) {
                throw new IllegalArgumentException(AppConstants.USERNAME_VALIDATION);
            }
            return adminRepository.findByUsernameIgnoreCase(username);
        } catch (Exception ex) {
            logger.error("Error finding admin by username", ex);
            throw ex;
        }
    }

    @Override
    public Optional<Admin> findById(Long id) {
        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException(AppConstants.ID_VALIDATION);
            }
            return adminRepository.findById(id);
        } catch (Exception ex) {
            logger.error("Error finding admin by ID", ex);
            throw ex;
        }
    }

}
