package com.InvestWithIntelligence.Services.ServicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.EntreprenuerMetaData;
import com.InvestWithIntelligence.Repositories.EmetaRepository;
import com.InvestWithIntelligence.Services.EmetaServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmetaServiceImpl implements EmetaServices {

    @Autowired
    private EmetaRepository emetaRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmetaServiceImpl.class);

    @Override
    public EntreprenuerMetaData updateEntreprenuermeta(long meta_id,
            EntreprenuerMetaData emodel) {
        try {
            if (emodel == null) {
                throw new IllegalArgumentException(IwIConstants.OBJ_NOT_NULL);
            }

            EntreprenuerMetaData e_metaData = emetaRepository.findById(meta_id)
                    .orElseThrow(() -> new EntityNotFoundException(IwIConstants.ID_NOT_FOUND));

            if (isEntrprenuerMetadataInvalid(emodel)) {
                return this.objectnullException();
            }
            e_metaData.setFname(emodel.getFname());
            e_metaData.setLname(emodel.getLname());
            e_metaData.setAddress(emodel.getAddress());
            e_metaData.setCity(emodel.getCity());
            e_metaData.setDescription(emodel.getDescription());
            e_metaData.setContact(emodel.getContact());

            return emetaRepository.save(e_metaData);

        } catch (Exception ex) {
            logger.error("Error in register Admin", ex);
            throw ex;
        }

    }

    private boolean isEntrprenuerMetadataInvalid(EntreprenuerMetaData emodel) {
        return emodel == null ||
                emodel.getFname() == null || emodel.getFname().isEmpty() ||
                emodel.getLname() == null || emodel.getLname().isEmpty() ||
                emodel.getContact() == null || emodel.getContact().isEmpty();

    }

    private EntreprenuerMetaData objectnullException() {
        throw new IllegalArgumentException(IwIConstants.NOT_NULL_EMPTY);
    }
}