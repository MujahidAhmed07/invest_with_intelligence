package com.InvestWithIntelligence.Models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
    private String startupName;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "team_size")
    private long teamSize;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_details")
    private String startupDetails;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "date_joined")
    private LocalDate dateJoined;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_location")
    private String startupLocation;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "startup_category")
    private String startupCategory;

    // @OneToOne
    // private Startup startup;

    // @OneToOne(mappedBy = "startup")
    // private Evaluation evaluationModel;

    @PrePersist
    protected void onCreate() {
        dateJoined = LocalDate.now();
    }

}