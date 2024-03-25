package com.InvestWithIntelligence.Controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.Startup;
import com.InvestWithIntelligence.Services.StartupServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/startup")
@CrossOrigin(origins = "*")

public class StartupController {

    @Autowired
    private StartupServices startupsServices;
    private static final Logger logger = LoggerFactory.getLogger(StartupController.class);

    @PostMapping("/add/details")
    private ResponseEntity<?> addStartups(@Valid @RequestBody Startup startupModel) {
        logger.info("in StartupController.addStartups() : {}");
        return new ResponseEntity<>(this.startupsServices.addStartup(startupModel), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<?> fetchStartups(@Valid @PathVariable("id") Long id) {
        Startup getDetails = this.startupsServices.getStartups(id);
        return new ResponseEntity<>(getDetails, HttpStatus.OK);
    }

    @PutMapping("/update/details/{id}")
    private ResponseEntity<?> updateStartupData(@Valid @PathVariable("id") Long id, @RequestBody Startup startupModel) {
        logger.info("in StartupController.updateStartupData() : {}");
        return new ResponseEntity<>(this.startupsServices.updateStartup(
                id, startupModel), HttpStatus.CREATED);
    }

    @GetMapping("/get/all/")
    private ResponseEntity<List<?>> GetAllStartups() {
        List<Startup> fecthStartup = this.startupsServices.fetchAll();
        return new ResponseEntity<>(fecthStartup, HttpStatus.OK);

    }

    @GetMapping("/home/")
    private ResponseEntity<List<?>> GetHomeStartups() {
        List<Startup> fecthStartup = this.startupsServices.GetHomeStartup();
        return new ResponseEntity<>(fecthStartup, HttpStatus.OK);

    }

    @GetMapping("/about/{id}")
    private ResponseEntity<?> getAboutStartup(@Valid @PathVariable("id") Long id) {
        Startup getAboutDetails = this.startupsServices.getAboutStartup(id);
        return new ResponseEntity<>(getAboutDetails, HttpStatus.OK);
    }
}
