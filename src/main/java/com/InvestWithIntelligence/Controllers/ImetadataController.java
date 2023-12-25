package com.InvestWithIntelligence.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.EntreprenuerMetaData;
import com.InvestWithIntelligence.Services.ImetaServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/imeta")
public class ImetadataController {

    @Autowired
    private ImetaServices imetaServices;

    private static final Logger logger = LoggerFactory.getLogger(ImetadataController.class);

    @PutMapping("/update/{id}")
    private ResponseEntity<?> add_i_meta(@Valid @PathVariable("id") long meta_id,
            @RequestBody EntreprenuerMetaData imodel) {

        try {
            logger.info("in ImetaServices.add_i_meta() : {}");
            return new ResponseEntity<>(this.imetaServices.updateInvestorMeta(meta_id, imodel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
