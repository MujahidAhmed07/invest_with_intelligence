package com.invest_with_intelligence.invest_with_intelligence.iwi_entities.AdminEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Iwi_admin_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iwi_admin_id;
    @Column(name = "admin_username")
    private String iwi_admin_username;
    @Column(name = "admin_password")
    private String iwi_admin_password;
    @Column(name = "admin_email")
    private String iwi_admin_email;

}
