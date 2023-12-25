package com.InvestWithIntelligence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.Entreprenuer;

@Repository
public interface EntreprenuerRepository extends JpaRepository<Entreprenuer, Long> {

    @Query("SELECT new Entreprenuer(e.id, e.username, e.email,e.password, e.role, e.entreprenuerMetadata) FROM Entreprenuer e WHERE e.email = :email")
    Entreprenuer findByEmail(@Param("email") String email);

    Entreprenuer findByUsername(String username);

}
