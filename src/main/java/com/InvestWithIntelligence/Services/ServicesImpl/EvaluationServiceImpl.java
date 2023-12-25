package com.InvestWithIntelligence.Services.ServicesImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.InvestWithIntelligence.Models.Evaluation;
import com.InvestWithIntelligence.Repositories.EvaluationRepository;
import com.InvestWithIntelligence.Services.EvaluationServices;
import com.InvestWithIntelligence.Utils.AppConstants;

@Service
public class EvaluationServiceImpl implements EvaluationServices {

    private EvaluationRepository evaluationRepository;

    @Override
    public Optional<Evaluation> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(AppConstants.ID_VALIDATION);
        }
        return this.evaluationRepository.findById(id);
    }

}
