package com.InvestWithIntelligence.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.Evaluation;
import com.InvestWithIntelligence.Services.EvaluationServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/model")
@CrossOrigin(origins = "*")
public class EvaluationController {

    @Autowired
    private EvaluationServices evaluationServices;

    private static final Logger logger = LoggerFactory.getLogger(EvaluationController.class);

    @GetMapping("/get/profit/{email}")
    public ResponseEntity<?> fetchById(@Valid @PathVariable("email") String email) {
        try {
            logger.info("Fetching Evaluation by ID: {}", email);
            return new ResponseEntity<>(evaluationServices.findByEmail(email), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Error fetching Evaluation by ID: {}", email, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/add/evaluation/data/{email}")
    public ResponseEntity<?> addEvaluationData(@PathVariable("email") String email,
            @Valid @RequestBody Evaluation evaluation) {
        try {
            logger.info("Adding Evaluation data for email: {}", email);
            return new ResponseEntity<>(evaluationServices.addEvaluation(email, evaluation), HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error("Error adding Evaluation data for email: {}", email, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
