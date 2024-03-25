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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "entreprenuer_metadata")
public class EntreprenuerMetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "entreprenuer_meta_id")
    private Long meta_id;

    @Column(name = "entreprenuer_fname")
    private String fname;

    @Column(name = "entreprenuer_lname")
    private String lname;

    @Column(name = "entreprenuer_contact")
    private String contact;

    @Column(name = "entreprenuer_city")
    private String city;

    @Column(name = "entreprenuer_address")
    private String address;

    @Column(name = "entreprenuer_description")
    private String description;

    public EntreprenuerMetaData(String fname, String lname, String contact, String city, String address,
            String description) {
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.city = city;
        this.address = address;
        this.description = description;
    }

    // @OneToOne
    // @JoinColumn(name = "entreprenuer_id")
    // private Entreprenuer entreprenuer;

}
