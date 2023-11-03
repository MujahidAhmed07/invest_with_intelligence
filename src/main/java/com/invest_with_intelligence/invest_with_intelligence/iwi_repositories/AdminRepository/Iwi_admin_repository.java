package com.invest_with_intelligence.invest_with_intelligence.iwi_repositories.AdminRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invest_with_intelligence.invest_with_intelligence.iwi_model.AdminEntity.Iwi_admin_entity;

@Repository
public interface Iwi_admin_repository extends JpaRepository<Iwi_admin_entity, Long> {

}
