package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Repositories.AdminRepository;
import com.InvestWithIntelligence.Services.AdminServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AdminServiceImpl implements AdminServices {

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin findByEmail(String admin_email) {
        if (admin_email == null || admin_email.isEmpty()) {
            throw new IllegalArgumentException(IwIConstants.EMAIL_VALIDATION);
        }
        return adminRepository.findByEmail(admin_email);
    }

    @Override
    public Admin addAccount(Admin adminModel) {
        try {

            if (adminModel == null) {
                throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
            }
            if (adminRepository.existsByUsernameIgnoreCase(adminModel.getUsername())) {
                throw new IllegalArgumentException(IwIConstants.USERNAME_EXISTS);
            }
            if (adminRepository.existsByEmailIgnoreCase(adminModel.getEmail())) {
                throw new IllegalArgumentException(IwIConstants.EMAIL_EXISTS);
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
                throw new IllegalArgumentException(IwIConstants.USERNAME_VALIDATION);
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
                throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
            }
            return adminRepository.findById(id);
        } catch (Exception ex) {
            logger.error("Error finding admin by ID", ex);
            throw ex;
        }
    }

    @Override
    public Admin updateAccount(Admin adminModel, Long id) {

        try {

            adminModel = (id == null || id <= 0) ? throwException() : adminModel;
            adminModel = (adminModel == null) ? objectnullException() : adminModel;

            adminModel = adminRepository.existsByUsernameIgnoreCase(adminModel.getUsername()) ? usernameExists()
                    : adminModel;
            adminModel = adminRepository.existsByEmailIgnoreCase(adminModel.getEmail()) ? emailExists()
                    : adminModel;

            Admin updateadminModel = this.adminRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(IwIConstants.ID_NOT_FOUND));

            updateadminModel.setUsername(adminModel.getUsername());
            updateadminModel.setEmail(adminModel.getEmail());
            updateadminModel.setPassword(adminModel.getPassword());

            updateadminModel = (updateadminModel == null) ? objectnullException() : updateadminModel;

            adminModel = this.adminRepository.save(updateadminModel);
            return adminModel;
        } catch (Exception ex) {
            logger.error("Error Updating admin by ID", ex);
            throw new IllegalArgumentException(IwIConstants.USERNAME_EXISTS);

        }

    }

    @Override
    public boolean deleteAccount(Long id) {
        this.adminRepository.deleteById(id);
        return true;
    }

    private Admin throwException() {
        throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
    }

    private Admin objectnullException() {
        throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
    }

    private Admin usernameExists() {
        throw new IllegalArgumentException(IwIConstants.USERNAME_EXISTS);
    }

    private Admin emailExists() {
        throw new IllegalArgumentException(IwIConstants.EMAIL_EXISTS);
    }

}
