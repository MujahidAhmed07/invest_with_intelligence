package com.InvestWithIntelligence.Services;

import com.InvestWithIntelligence.Models.EntreprenuerMetaData;
import com.InvestWithIntelligence.Models.InvestorMetadata;

public interface ImetaServices {

    InvestorMetadata updateInvestorMeta(long meta_id, EntreprenuerMetaData emodel);

}