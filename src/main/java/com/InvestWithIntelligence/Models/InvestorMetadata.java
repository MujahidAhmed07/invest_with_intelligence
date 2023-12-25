package com.InvestWithIntelligence.Models;

import com.InvestWithIntelligence.Utils.AppConstants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
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

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_fname")
    private String fname;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_lname")
    private String lname;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_contact")
    private String contact;

}
