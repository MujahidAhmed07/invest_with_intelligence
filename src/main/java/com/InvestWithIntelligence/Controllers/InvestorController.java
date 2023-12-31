package com.InvestWithIntelligence.Controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Services.InvestorServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/investor")
public class InvestorController {

    @Autowired
    private InvestorServices investorServices;

    private static final Logger logger = LoggerFactory.getLogger(InvestorController.class);

    @GetMapping("/get/investorusername/{username}")
    public ResponseEntity<?> fetchByUsername(@Valid @PathVariable("username") String username) {
        try {
            logger.info("in InvestorController.fetchByUsername() : {}");
            Investor fetchedInvestor = investorServices.findByUsername(username);
            return new ResponseEntity<>(fetchedInvestor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<?> fetchByEmail(@Valid @PathVariable String email) {
        try {
            logger.info("in InvestorController.fetchByEmail() : {}");
            Investor fetchedInvestor = investorServices.findByEmail(email);
            return new ResponseEntity<>(fetchedInvestor, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/account")
    public ResponseEntity<?> addInvestorAccount(@Valid @RequestBody Investor investorModel) {
        logger.info("in InvestorController.addInvestorAccount() : {}");
        Investor addedInvestor = investorServices.addAccount(investorModel);
        return new ResponseEntity<>(addedInvestor, HttpStatus.CREATED);
    }

    @GetMapping("/get/all/")
    public ResponseEntity<List<?>> fetchAll() {
        try {
            logger.info("in InvestorController.fetchAll() : {}");
            List<Investor> allInvestors = investorServices.fetchAll();
            return new ResponseEntity<>(allInvestors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
