package com.invest_with_intelligence.invest_with_intelligence.iwi_model.EntreprenuerEntity.iwi_startup_model;

import java.util.Date;

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
@Table(name = "startup")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Iwi_startup_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "startup_id")
    private Long iwi_startup_id;

    @Column(name = "startup_name")
    private String iwi_startup_name;

    @Column(name = "team_size")
    private int iwi_team_size;

    @Column(name = "startup_details")
    private String iwi_startup_details;

    @Column(name = "date_joined")
    private Date iwi_date_joined;

    @Column(name = "startup_location")
    private String iwi_startup_location;

    @Column(name = "startup_category")
    private String iwi_startup_category;

}