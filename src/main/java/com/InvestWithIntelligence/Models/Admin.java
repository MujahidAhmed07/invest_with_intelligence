package com.InvestWithIntelligence.Models;

import com.InvestWithIntelligence.Utils.IwIConstants;

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
@Table(name = "admin_data")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    private Long id;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "admin_username")
    private String username;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "admin_email")
    private String email;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "admin_password")
    private String password;

    @NotEmpty(message = IwIConstants.NOT_EMPTY)
    @Column(name = "role")
    private String role = IwIConstants.ADMIN_ROLE;
}
