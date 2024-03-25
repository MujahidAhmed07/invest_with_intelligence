package com.InvestWithIntelligence.Models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

    @Column(name = "startup_short_details")
    private String startupShortDetails;

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

    public Startup(String startupName, long teamSize, EntreprenuerMetaData entreprenuerMetaData) {
        this.startupName = startupName;
        this.teamSize = teamSize;
        this.entreprenuerMetaData = entreprenuerMetaData;
    }

    public Startup(String startupName, long teamSize, String startupDetails, String startupShortDetails,
            LocalDate dateJoined, String startupLocation, String startupCategory, String fname, String lname,
            String contact, String city, String address, String description, long model_id) {
        this.startupName = startupName;
        this.teamSize = teamSize;
        this.startupDetails = startupDetails;
        this.startupShortDetails = startupShortDetails;
        this.dateJoined = dateJoined;
        this.startupLocation = startupLocation;
        this.startupCategory = startupCategory;
        this.evaluation = new Evaluation(model_id);
        this.entreprenuerMetaData = new EntreprenuerMetaData(fname, lname, contact, city, address, description);
    }

    public Startup(long startup_id, String startupName, String startupShortDetails) {
        this.startup_id = startup_id;
        this.startupName = startupName;
        this.startupShortDetails = startupShortDetails;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprenuer_meta_id")
    private EntreprenuerMetaData entreprenuerMetaData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Evaluation evaluation;

}