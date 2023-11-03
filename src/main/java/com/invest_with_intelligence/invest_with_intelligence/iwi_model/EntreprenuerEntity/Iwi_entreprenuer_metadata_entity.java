package com.invest_with_intelligence.invest_with_intelligence.iwi_model.EntreprenuerEntity;

import java.io.File;

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
@Table(name = "entreprenuer_metadata")
public class Iwi_entreprenuer_metadata_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dashboard_entity_id")
    private Long iwi_dashboard_entity_id;

    @Column(name = "entreprenuer_fname")
    private String iwi_entreprenuer_fname;

    @Column(name = "entreprenuer_lname")
    private String iwi_entreprenuer_lname;

    @Column(name = "entreprenuer_dataset")
    private File iwi_entreprenuer_dataset;

    @Column(name = "entreprenuer_contact")
    private String iwi_admin_contact;

}
