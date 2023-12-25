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

import com.InvestWithIntelligence.Models.Entreprenuer;
import com.InvestWithIntelligence.Services.EntreprenuerServices;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/iwi/entreprenuer")
public class EntreprenuerController {

    @Autowired
    private EntreprenuerServices entreprenuerServices;

    private static final Logger logger = LoggerFactory.getLogger(EntreprenuerController.class);

    @PostMapping("/add/account")
    public ResponseEntity<?> addAccount(@Valid @RequestBody Entreprenuer entreprenuerModel) {
        logger.info("in EntreprenuerController.addAccount() : {}");
        Entreprenuer addedAccount = entreprenuerServices.addAccount(entreprenuerModel);
        return new ResponseEntity<>(addedAccount, HttpStatus.CREATED);
    }

    @GetMapping("/get/username/{username}")
    public ResponseEntity<?> fetchByUsername(@Valid @PathVariable("username") String username) {
        logger.info("in EntreprenuerController.fetchByUsername() : {}");
        Entreprenuer fetchedAccount = this.entreprenuerServices.findByUsername(username);
        return new ResponseEntity<>(fetchedAccount, HttpStatus.OK);
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<?> fetchByEmail(@Valid @PathVariable String email) {
        logger.info("in EntreprenuerController.fetchByEmail() : {}");
        Entreprenuer fetchedAccount = entreprenuerServices.findByEmail(email);
        return new ResponseEntity<>(fetchedAccount, HttpStatus.OK);
    }

    @GetMapping("/get/id/{entreprenuer_id}")
    public ResponseEntity<?> fetchById(@Valid @PathVariable Long entreprenuer_id) {
        logger.info("in EntreprenuerController.fetchById() : {}");
        Entreprenuer fetchedAccount = entreprenuerServices.findById(entreprenuer_id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "EntreprenuerModel with ID " + entreprenuer_id + " not found"));
        return new ResponseEntity<>(fetchedAccount, HttpStatus.OK);
    }

    @GetMapping("/get/allentreprenuer")
    public ResponseEntity<List<Entreprenuer>> fetchAll() {
        logger.info("in EntreprenuerController.fetchAll() : {}");
        List<Entreprenuer> allEntreprenuers = entreprenuerServices.fetchAll();
        return new ResponseEntity<>(allEntreprenuers, HttpStatus.OK);
    }
}
