package com.InvestWithIntelligence.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.Startup;
import com.InvestWithIntelligence.Services.StartupServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/startup")
public class StartupController {

    @Autowired
    private StartupServices startupsServices;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/add/account")
    private ResponseEntity<?> addStartup(@Valid @RequestBody Startup startupModel) {
        logger.info("in AdminController.add() : {}");
        return new ResponseEntity<>(this.startupsServices.addStartup(startupModel), HttpStatus.CREATED);
    }
}
