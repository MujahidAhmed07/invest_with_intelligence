package com.InvestWithIntelligence.Services;

import java.util.Optional;

import com.InvestWithIntelligence.Models.Evaluation;

public interface EvaluationServices {

    Optional<Evaluation> findById(Long id);

    Evaluation addEvaluation(Evaluation evaluation);

}
