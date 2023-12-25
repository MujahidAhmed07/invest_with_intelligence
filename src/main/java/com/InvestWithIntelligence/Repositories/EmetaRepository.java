package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.EntreprenuerMetaData;

@Repository
public interface EmetaRepository extends JpaRepository<EntreprenuerMetaData, Long> {

}
