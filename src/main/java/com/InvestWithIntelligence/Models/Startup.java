package com.InvestWithIntelligence.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "startup")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Startup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "startup_id")
    private Long startup_id;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_name")
    private String startup_name;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "team_size")
    private long team_size;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_details")
    private String startup_details;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "date_joined")
    private Date date_joined;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_location")
    private String startup_location;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_category")
    private String startup_category;

    // @OneToOne
    // @JoinColumn(name = "entreprenuer_id")
    // private Entreprenuer entreprenuer;

    // @OneToOne(mappedBy = "startup")
    // private Evaluation evaluationModel;

}