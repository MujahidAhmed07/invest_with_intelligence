package com.InvestWithIntelligence.Controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Services.InvestorServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/investor")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class InvestorController {

    @Autowired
    private InvestorServices investorServices;

    private static final Logger logger = LoggerFactory.getLogger(InvestorController.class);

    @PutMapping("/update/{email}")
    public ResponseEntity<?> updateByEmail(@Valid @PathVariable("email") String email, Investor investor) {
        try {
            logger.info("Updating investor by email: {}", email);
            Investor updateData = investorServices.updateByEmail(email, investor);
            return new ResponseEntity<>(updateData, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error updating investor by email: {}", email, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
            logger.info("Investor get Account Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add/account")
    public ResponseEntity<?> addInvestorAccount(@Valid @RequestBody Investor investorModel) {
        logger.info("in InvestorController.addInvestorAccount() : {}");
        Investor addedInvestor = investorServices.addAccount(investorModel);
        return new ResponseEntity<>(addedInvestor, HttpStatus.CREATED);
    }

    // @PreAuthorize("hasRole('ROLE_INVESTOR')")
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

    @DeleteMapping("delete/account/{id}")
    private ResponseEntity<?> deleteAccount(@Valid @PathVariable("id") Long id) {
        logger.info("in InvestorController.deleteAccount() : {}");
        this.investorServices.deleteById(id);
        return new ResponseEntity<>("Account Deleted", HttpStatus.OK);
    }

}
