package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Evaluation;
import com.InvestWithIntelligence.Repositories.EvaluationRepository;
import com.InvestWithIntelligence.Services.EvaluationServices;
import com.InvestWithIntelligence.Utils.IwIConstants;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EvaluationServiceImpl implements EvaluationServices {

    @Autowired
    private EvaluationRepository evaluationRepository;
    private static final Logger logger = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    @Override
    public Optional<Evaluation> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(IwIConstants.ID_VALIDATION);
        }
        return this.evaluationRepository.findById(id);
    }

    @Override
    public Evaluation addEvaluation(String email, Evaluation evaluation) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }

        try {
            Evaluation existingEvaluation = evaluationRepository.findByCustomEmailEvaluation(email);

            if (existingEvaluation == null) {
                throw new EntityNotFoundException("Evaluation not found for the given email" + existingEvaluation);
            }

            existingEvaluation.setProfit(evaluation.getProfit());
            return evaluationRepository.save(existingEvaluation);

        } catch (Exception ex) {
            logger.error("Error in updating profit data", ex);
            throw new RuntimeException("Error in updating profit data", ex);
        }
    }

    @Override
    public String findByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be null or empty");
        }
        try {

            return evaluationRepository.getProfit(email);

        } catch (Exception ex) {
            logger.error("Error in updating profit data", ex);
            throw new RuntimeException("Error in updating profit data", ex);
        }
    }

}
