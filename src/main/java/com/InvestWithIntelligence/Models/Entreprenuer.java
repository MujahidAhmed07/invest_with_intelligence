package com.InvestWithIntelligence.Models;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.InvestWithIntelligence.Utils.IwIConstants;
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
public class Entreprenuer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entreprenuer_id")
    private Long id;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "entreprenuer_username")
    private String username;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "entreprenuer_email")
    private String email;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "entreprenuer_password")
    private String password;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "role")
    // @Enumerated(EnumType.STRING)
    private String role = "ENTREPRENUER";

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "entreprenuer_meta_id")
    private EntreprenuerMetaData entreprenuerMetadata;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "startup_id")
    private Startup startup;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Evaluation evaluation;

    public Entreprenuer(Long id, String username, String email, String password,
            EntreprenuerMetaData entreprenuerMetadata) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.entreprenuerMetadata = entreprenuerMetadata;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
