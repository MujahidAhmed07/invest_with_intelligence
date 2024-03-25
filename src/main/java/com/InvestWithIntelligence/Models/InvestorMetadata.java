package com.InvestWithIntelligence.Models;

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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "investor_metadata")
public class InvestorMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "investor_meta_id")
    private Long meta_id;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_fname")
    private String fname;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_lname")
    private String lname;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_contact")
    private String contact;

    @Column(name = "investor_city")
    private String city;

    @Column(name = "investor_address")
    private String address;

    @Column(name = "investor_description")
    private String description;

}
