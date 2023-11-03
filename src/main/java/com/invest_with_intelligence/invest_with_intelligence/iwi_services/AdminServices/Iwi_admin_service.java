package com.invest_with_intelligence.invest_with_intelligence.iwi_services.AdminServices;

import java.util.List;

import com.invest_with_intelligence.invest_with_intelligence.iwi_model.AdminEntity.Iwi_admin_entity;

public interface Iwi_admin_service {

    List<Iwi_admin_entity> get_admin();

    Iwi_admin_entity get_admin_by_id(Long admin_login_id);

    Iwi_admin_entity add_admin_account(Iwi_admin_entity iwi_admin_entity);

   Iwi_admin_entity change_admin_account(Iwi_admin_entity iwi_admin_entity);

}
