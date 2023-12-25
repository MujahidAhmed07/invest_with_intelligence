package com.InvestWithIntelligence.Models;

import com.InvestWithIntelligence.Utils.AppConstants;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "investor_data")
public class Investor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "investor_id")
    private Long id;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_username")
    private String username;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_email")
    private String email;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "investor_password")
    private String password;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "role")
    private String role = AppConstants.INVESTOR_ROLE;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "investor_meta_id")
    private InvestorMetadata investorMetadata;
}
