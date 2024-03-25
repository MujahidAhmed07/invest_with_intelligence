package com.InvestWithIntelligence.Services;

import java.util.List;
import java.util.Optional;

import com.InvestWithIntelligence.Models.Entreprenuer;

import jakarta.validation.Valid;

public interface EntreprenuerServices {

    Entreprenuer findByUsername(String entreprenuer_username);

    Entreprenuer findByEmail(String entreprenuer_email);

    Optional<Entreprenuer> findById(Long entreprenuer_id);

    Entreprenuer addAccount(Entreprenuer entreprenuerModel);

    List<Entreprenuer> fetchAll();

    void deleteById(@Valid Long id);

    Entreprenuer fetchByEmailByRole(String email);

    Entreprenuer findByCustomEmail(String email);

}
