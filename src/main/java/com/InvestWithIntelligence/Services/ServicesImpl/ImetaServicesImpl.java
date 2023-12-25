package com.InvestWithIntelligence.Services.ServicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.EntreprenuerMetaData;
import com.InvestWithIntelligence.Models.InvestorMetadata;
import com.InvestWithIntelligence.Repositories.ImetaRepository;
import com.InvestWithIntelligence.Services.ImetaServices;
import com.InvestWithIntelligence.Utils.AppConstants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ImetaServicesImpl implements ImetaServices {

    @Autowired
    private ImetaRepository imetaRepository;

    private static final Logger logger = LoggerFactory.getLogger(ImetaServicesImpl.class);

    @Override
    public InvestorMetadata updateInvestorMeta(long meta_id, EntreprenuerMetaData emodel) {
        try {
            if (emodel == null) {
                throw new IllegalArgumentException(AppConstants.OBJ_NOT_NULL);
            }

            InvestorMetadata i_metaData = imetaRepository.findById(meta_id)
                    .orElseThrow(() -> new EntityNotFoundException(AppConstants.ID_NOT_FOUND));

            i_metaData.setFname(emodel.getFname());
            i_metaData.setLname(emodel.getLname());
            i_metaData.setContact(emodel.getContact());

            return imetaRepository.save(i_metaData);

        } catch (Exception ex) {
            logger.error("Error in register Investor meta data", ex);
            throw ex;
        }
    }

}
