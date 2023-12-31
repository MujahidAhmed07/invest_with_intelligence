package com.InvestWithIntelligence.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.Admin;
import com.InvestWithIntelligence.Services.AdminServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private AdminServices adminServices;

    @GetMapping("/get/username/{username}")
    private ResponseEntity<?> fetchByUsername(@Valid @PathVariable("username") String username) {
        try {
            logger.info("in AdminController.fetchByUsername() : {}");
            return new ResponseEntity<>(this.adminServices.findByUsername(username), HttpStatus.OK);
        } catch (Exception e) {
            logger.info("Get Admin Account By Username");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get/email/{email}")
    private ResponseEntity<?> fetchByEmail(@Valid @PathVariable String email) {
        try {
            logger.info("in AdminController.fetchByEmail() : {}");
            return new ResponseEntity<>(this.adminServices.findByEmail(email), HttpStatus.OK);
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
        try {
            logger.info("in AdminController.add_admin_account() : {}");
            return new ResponseEntity<>(this.adminServices.addAccount(adminModel), HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("Admin Account Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("update/account/{id}")
    private ResponseEntity<?> updateAccount(@Valid @PathVariable("id") Long id, @RequestBody Admin adminModel) {
        try {
            logger.info("in AdminController.updateAccount() : {}");
            Admin updateAdmin = this.adminServices.updateAccount(adminModel, id);
            return new ResponseEntity<>(updateAdmin, HttpStatus.CREATED);

        } catch (Exception e) {
            logger.info("Update Admin Account Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("delete/account/{id}")
    private ResponseEntity<?> deleteAccount(@Valid @PathVariable("id") Long id) {
        try {
            if (id == null || id <= 0) {
                return new ResponseEntity<>(IwIConstants.ID_NOT_FOUND, HttpStatus.NOT_FOUND);
            }
            Optional<Admin> adminModelOptional = this.adminServices.findById(id);
            if (adminModelOptional.isEmpty()) {
                return new ResponseEntity<>("No Data Exists for ID: " + id, HttpStatus.NOT_FOUND);
            }
            this.adminServices.deleteAccount(id);
            return new ResponseEntity<>(IwIConstants.DATA_DELETED + id, HttpStatus.OK);
        } catch (Exception e) {
            logger.info("Delete Admin Account Error");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
