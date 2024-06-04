package com.InvestWithIntelligence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.Startup;

@Repository
public interface StartupRepository extends JpaRepository<Startup, Long> {

    @Query("SELECT new com.InvestWithIntelligence.Models.Startup(s.startupName, s.teamSize, s.startupDetails, s.startupShortDetails, s.dateJoined, s.startupLocation, s.startupCategory, s.entreprenuerMetaData.fname, s.entreprenuerMetaData.lname, s.entreprenuerMetaData.contact, s.entreprenuerMetaData.city, s.entreprenuerMetaData.address, s.entreprenuerMetaData.description, e.e_id) FROM Startup s JOIN s.evaluation e WHERE s.startup_id = :id")
    Startup getAboutData(@Param("id") Long id);

    @Query("SELECT new com.InvestWithIntelligence.Models.Startup(s.startup_id, s.startupName, s.startupShortDetails) FROM Startup s")
    List<Startup> GetHomeStartups();
}
