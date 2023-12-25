package com.InvestWithIntelligence.Controllers;

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

import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Services.AdminServices;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/get/username/{username}")
    private ResponseEntity<?> fetchByUsername(@Valid @PathVariable("username") String username) {
        logger.info("in AdminController.fetchByUsername() : {}");
        return new ResponseEntity<>(this.adminServices.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/get/email/{email}")
    private ResponseEntity<?> fetchByEmail(@Valid @PathVariable String email) {
        try {
            logger.info("in AdminController.fetchByEmail() : {}");
            return new ResponseEntity<>(this.adminServices.findByUsername(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get/id/{Id}")
    private ResponseEntity<?> fetchById(@Valid @PathVariable Long Id) {
        try {
            logger.info("in AdminController.fetchById() : {}");
            return new ResponseEntity<>(this.adminServices.findById(Id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/add/account")
    private ResponseEntity<?> add_admin_account(@Valid @RequestBody Admin adminModel) {

        logger.info("in AdminController.add() : {}");
        return new ResponseEntity<>(this.adminServices.addAccount(adminModel), HttpStatus.CREATED);
    }

}
