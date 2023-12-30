package com.InvestWithIntelligence.Services.ServicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Startup;
import com.InvestWithIntelligence.Repositories.StartupRepository;
import com.InvestWithIntelligence.Services.StartupServices;

@Service
public class StartupServiceImpl implements StartupServices {
    private static final Logger logger = LoggerFactory.getLogger(StartupServiceImpl.class);
    private StartupRepository startupRepository;

    @Override
    public Startup addStartup(Startup startupModel) {
        try {
            // Check if startupModel is not null
            if (startupModel == null) {
                throw new IllegalArgumentException("StartupModel cannot be null or Empty");
            }
            return this.startupRepository.save(startupModel);
        } catch (Exception ex) {
            // Log the error
            logger.error("Error adding startup", ex);
            return null;
        }
    }

}
