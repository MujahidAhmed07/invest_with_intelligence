package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.InvestorMetadata;

@Repository
public interface ImetaRepository extends JpaRepository<InvestorMetadata, Long> {

}
