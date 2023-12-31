package com.InvestWithIntelligence.Services.ServicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.InvestorMetadata;
import com.InvestWithIntelligence.Repositories.ImetaRepository;
import com.InvestWithIntelligence.Services.ImetaServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ImetaServicesImpl implements ImetaServices {

    @Autowired
    private ImetaRepository imetaRepository;

    private static final Logger logger = LoggerFactory.getLogger(ImetaServicesImpl.class);

    @Override
    public InvestorMetadata updateInvestorMeta(long meta_id, InvestorMetadata imodel) {
        try {
            if (imodel == null) {
                throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
            }

            InvestorMetadata i_metaData = imetaRepository.findById(meta_id)
                    .orElseThrow(() -> new EntityNotFoundException(IwIConstants.ID_NOT_FOUND));

            if (isInvestorMetadataInvalid(imodel)) {
                return this.objectnullException();
            }
            i_metaData.setFname(imodel.getFname());
            i_metaData.setLname(imodel.getLname());
            i_metaData.setContact(imodel.getContact());

            i_metaData = (i_metaData == null) ? this.objectnullException() : i_metaData;

            i_metaData = this.imetaRepository.save(i_metaData);

            return i_metaData;

        } catch (Exception ex) {
            logger.error("Error in register Investor meta data", ex);
            throw ex;
        }
    }

    private InvestorMetadata objectnullException() {
        throw new IllegalArgumentException(IwIConstants.NOT_NULL_EMPTY);
    }

    private boolean isInvestorMetadataInvalid(InvestorMetadata imodel) {
        return imodel == null ||
                imodel.getFname() == null || imodel.getFname().isEmpty() ||
                imodel.getLname() == null || imodel.getLname().isEmpty() ||
                imodel.getContact() == null || imodel.getContact().isEmpty();

    }
}
