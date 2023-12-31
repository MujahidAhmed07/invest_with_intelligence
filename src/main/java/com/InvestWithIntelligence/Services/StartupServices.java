package com.InvestWithIntelligence.Services;

import java.util.Optional;

import com.InvestWithIntelligence.Models.Startup;

import jakarta.validation.Valid;

public interface StartupServices {

    Startup addStartup(Startup startupModel);

    Optional<Startup> getStartups(@Valid Startup startup, Long id);

}
