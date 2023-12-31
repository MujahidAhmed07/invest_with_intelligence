package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Startup;
import com.InvestWithIntelligence.Repositories.StartupRepository;
import com.InvestWithIntelligence.Services.StartupServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.validation.Valid;

@Service
public class StartupServiceImpl implements StartupServices {
    private static final Logger logger = LoggerFactory.getLogger(StartupServiceImpl.class);

    @Autowired
    private StartupRepository startupRepository;

    @Override
    public Startup addStartup(Startup startupModel) {
        try {
            // Check if startupModel is not null
            if (startupModel == null) {
                throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
            }
            return this.startupRepository.save(startupModel);
        } catch (Exception ex) {
            // Log the error
            logger.error("Error adding startup", ex);
            throw ex;
        }
    }

    @Override
    public Optional<Startup> getStartups(@Valid Startup startup, Long id) {

        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
            }
            return this.startupRepository.findById(id);
        } catch (Exception ex) {
            logger.error("Error getting startup", ex);
            throw ex;
        }

    }

}
