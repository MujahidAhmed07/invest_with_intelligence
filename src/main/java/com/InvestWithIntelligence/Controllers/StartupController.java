package com.InvestWithIntelligence.Controllers;

import java.util.Optional;

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

import com.InvestWithIntelligence.Models.Startup;
import com.InvestWithIntelligence.Services.StartupServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/startup")
public class StartupController {

    @Autowired
    private StartupServices startupsServices;
    private static final Logger logger = LoggerFactory.getLogger(StartupController.class);

    @PostMapping("/add/details")
    private ResponseEntity<?> addStartups(@Valid @RequestBody Startup startupModel) {
        logger.info("in StartupController.addStartups() : {}");
        return new ResponseEntity<>(this.startupsServices.addStartup(startupModel), HttpStatus.CREATED);
    }

    @GetMapping("/get/id")
    private ResponseEntity<?> fetchStartups(@Valid @PathVariable("id") Startup startupModel, Long id) {
        Optional<Startup> getDetails = this.startupsServices.getStartups(startupModel, id);
        return new ResponseEntity<>(getDetails, HttpStatus.OK);
    }
}
