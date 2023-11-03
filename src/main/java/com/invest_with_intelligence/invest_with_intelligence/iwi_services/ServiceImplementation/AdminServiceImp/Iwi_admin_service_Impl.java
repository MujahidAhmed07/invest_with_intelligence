package com.invest_with_intelligence.invest_with_intelligence.iwi_services.ServiceImplementation.AdminServiceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.invest_with_intelligence.invest_with_intelligence.iwi_entities.AdminEntity.Iwi_admin_entity;
import com.invest_with_intelligence.invest_with_intelligence.iwi_repositories.AdminRepository.Iwi_admin_repository;
import com.invest_with_intelligence.invest_with_intelligence.iwi_services.AdminServices.Iwi_admin_service;

@Service
public class Iwi_admin_service_Impl implements Iwi_admin_service {

    private Iwi_admin_repository iwi_admin_repository;

    @Override
    public Iwi_admin_entity add_admin_account(Iwi_admin_entity iwi_admin_entity) {
        return iwi_admin_repository.save(iwi_admin_entity);
    }

    @Override
    public List<Iwi_admin_entity> get_admin() {
        throw new UnsupportedOperationException("Unimplemented method 'get_admin'");
    }

    @Override
    public Iwi_admin_entity get_admin_by_id(Long admin_login_id) {
        throw new UnsupportedOperationException("Unimplemented method 'get_admin_by_id'");
    }

    @Override
    public Iwi_admin_entity change_admin_account(Iwi_admin_entity iwi_admin_entity) {
        throw new UnsupportedOperationException("Unimplemented method 'change_admin_account'");
    }

}
