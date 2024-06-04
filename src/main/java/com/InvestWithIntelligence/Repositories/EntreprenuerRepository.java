package com.InvestWithIntelligence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.InvestWithIntelligence.Models.Entreprenuer;

@Repository
public interface EntreprenuerRepository extends JpaRepository<Entreprenuer, Long> {

        @Query("SELECT new Entreprenuer(e.id, e.username, e.email,e.password,e.role, e.entreprenuerMetadata) FROM Entreprenuer e WHERE e.email = :email")
        Entreprenuer findByEmail(@Param("email") String email);

        @Query("SELECT e, m, s, ev FROM Entreprenuer e " +
                        "JOIN e.entreprenuerMetadata m " +
                        "JOIN e.startup s " +
                        "JOIN e.evaluation ev")
        List<Entreprenuer> findAllCustomQuery();

        @Query("SELECT e, m, s, ev FROM Entreprenuer e " +
                        "JOIN e.entreprenuerMetadata m " +
                        "JOIN e.startup s " +
                        "JOIN e.evaluation ev WHERE e.email = :email")
        Entreprenuer findByCustomEmail(@Param("email") String email);

        Entreprenuer findByUsername(String username);

        boolean existsByUsername(String username);

        boolean existsByEmail(String email);

        @Query("SELECT new Entreprenuer(e.role) FROM Entreprenuer e WHERE e.email = :email")
        Entreprenuer findByRole(@Param("email") String email);

}
