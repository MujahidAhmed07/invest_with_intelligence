package com.invest_with_intelligence.invest_with_intelligence.iwi_model.EntreprenuerEntity;

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
@Table(name = "entreprenuer")
public class Iwi_entreprenuer_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entreprenuer_id")
    private Long Iwi_entreprenuer_id;
    @Column(name = "entreprenuer_username")
    private String iwi_admin_username;
    @Column(name = "entreprenuer_email")
    private String iwi_admin_email;
    @Column(name = "entreprenuer_password")
    private String iwi_admin_password;

}
