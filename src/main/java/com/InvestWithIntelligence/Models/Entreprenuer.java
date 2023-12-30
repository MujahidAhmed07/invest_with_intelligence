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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "entreprenuer")
@ToString
public class Entreprenuer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entreprenuer_id")
    private Long id;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "entreprenuer_username")
    private String username;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "entreprenuer_email")
    private String email;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "entreprenuer_password")
    private String password;

    @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "role")
    private String role = AppConstants.ENTREPRENUER_ROLE;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprenuer_meta_id")
    private EntreprenuerMetaData entreprenuerMetadata;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_id")
    private Startup startup;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Evaluation evaluation;

    public Entreprenuer(Long id, String username, String email, String password, String role,
            EntreprenuerMetaData entreprenuerMetadata) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.entreprenuerMetadata = entreprenuerMetadata;
    }
}
