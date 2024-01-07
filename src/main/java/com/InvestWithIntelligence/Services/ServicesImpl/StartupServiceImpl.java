package com.InvestWithIntelligence.Services.ServicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Startup;
import com.InvestWithIntelligence.Repositories.StartupRepository;
import com.InvestWithIntelligence.Services.StartupServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.persistence.EntityNotFoundException;

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

            if (isStartupInvalid(startupModel)) {
                return this.objectnullException();
            }

            return this.startupRepository.save(startupModel);
        } catch (Exception ex) {
            // Log the error
            logger.error("Error adding startup", ex);
            throw ex;
        }
    }

    @Override
    public Startup getStartups(Long id) {

        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
            }
            return this.startupRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(IwIConstants.ID_NOT_FOUND));
        } catch (Exception ex) {
            logger.error("Error getting startup", ex);
            throw ex;
        }

    }

    @Override
    public Startup updateStartup(Long id, Startup startupModel) {
        try {
            if (id == null || id <= 0) {
                logger.error("Error 1");
                throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
            }

            if (startupModel == null) {
                logger.error("Error 2");
                throw new IllegalArgumentException(IwIConstants.NOT_NULL_EMPTY);
            }

            Startup startDetailsUpdate = this.startupRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException(IwIConstants.ID_NOT_FOUND));

            startDetailsUpdate.setStartupName(startupModel.getStartupName());
            startDetailsUpdate.setTeamSize(startupModel.getTeamSize());
            startDetailsUpdate.setStartupDetails(startupModel.getStartupDetails());
            startDetailsUpdate.setStartupLocation(startupModel.getStartupName());
            startDetailsUpdate.setStartupCategory(startupModel.getStartupCategory());

            if (isStartupInvalid(startDetailsUpdate)) {
                logger.error("Error 3");
                return this.objectnullException();
            }

            return this.startupRepository.save(startDetailsUpdate);
        } catch (Exception e) {
            logger.error("Error 4");
            throw new IllegalArgumentException(IwIConstants.NOT_NULL_EMPTY);
        }

    }

    private boolean isStartupInvalid(Startup startup) {
        return startup == null ||
                (startup != null && (startup.getStartupName() == null || startup.getStartupName().isEmpty()
                        || (startup.getTeamSize() <= 0) ||
                        startup.getStartupDetails() == null || startup.getStartupDetails().isEmpty() ||
                        startup.getDateJoined() == null || startup.getStartupName() == null
                        || startup.getStartupName().isEmpty() ||
                        startup.getStartupCategory() == null || startup.getStartupCategory().isEmpty()));
    }

    private Startup objectnullException() {
        throw new IllegalArgumentException(IwIConstants.NOT_NULL_EMPTY);
    }
}
