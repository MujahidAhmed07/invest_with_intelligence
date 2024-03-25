package com.InvestWithIntelligence.Services;

import java.util.List;

import com.InvestWithIntelligence.Models.Startup;

public interface StartupServices {

    Startup addStartup(Startup startupModel);

    Startup getStartups(Long id);

    Startup updateStartup(Long id, Startup startupModel);

    List<Startup> fetchAll();

    Startup getAboutStartup(Long id);

    List<Startup> GetHomeStartup();

}
