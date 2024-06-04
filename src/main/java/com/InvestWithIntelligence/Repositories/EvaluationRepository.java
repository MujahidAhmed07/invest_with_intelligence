package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.InvestWithIntelligence.Models.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    @Query("SELECT ev FROM Entreprenuer e JOIN e.evaluation ev WHERE e.email = :email")
    Evaluation findByCustomEmailEvaluation(@Param("email") String email);

    @Query("SELECT ev.profit FROM Entreprenuer e JOIN e.evaluation ev WHERE e.email = :email")
    String getProfit(String email);

}