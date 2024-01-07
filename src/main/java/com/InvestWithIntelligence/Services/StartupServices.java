package com.InvestWithIntelligence.Services;

import com.InvestWithIntelligence.Models.Startup;

public interface StartupServices {

    Startup addStartup(Startup startupModel);

    Startup getStartups(Long id);

    Startup updateStartup(Long id, Startup startupModel);

}
