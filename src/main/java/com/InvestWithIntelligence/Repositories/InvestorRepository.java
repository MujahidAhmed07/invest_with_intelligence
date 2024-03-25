package com.InvestWithIntelligence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.InvestWithIntelligence.Models.Investor;
import com.InvestWithIntelligence.Models.InvestorMetadata;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {

    Investor findByUsername(String username);

    Investor findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT new Investor(i.id, i.username, i.email,i.password, i.investorMetadata) FROM Investor i WHERE i.email = :email")
    Investor findByCustomEmail(@Param("email") String email);

    @Query("SELECT i, m FROM Investor i JOIN i.investorMetadata m")
    List<Investor> findAllCustomQuery();

    @Query("UPDATE Investor i SET  i.password = :password, i.investorMetadata = :metadata WHERE i.email = :email")
    Investor updateInvestor(@Param("email") String email,
            @Param("password") String password, @Param("metadata") InvestorMetadata metadata);

}
