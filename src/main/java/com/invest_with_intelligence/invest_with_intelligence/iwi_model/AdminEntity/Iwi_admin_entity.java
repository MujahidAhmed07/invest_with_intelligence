package com.invest_with_intelligence.invest_with_intelligence.iwi_model.AdminEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "admin_data")
public class Iwi_admin_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Long iwi_admin_id;

    @Column(name = "admin_username")
    private String iwi_admin_username;

    @Column(name = "admin_password")
    private String iwi_admin_password;

    @Column(name = "admin_email")
    private String iwi_admin_email;

}
