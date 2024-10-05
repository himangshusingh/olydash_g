package com.olympic.olydash.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_Country", uniqueConstraints = @UniqueConstraint(columnNames = "iso_code"))
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long country_id;
    @Column
    @NotNull
    private String Country_Name;
    @Column    
    private Long iso_code;


    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public @NotNull String getCountry_Name() {
        return Country_Name;
    }

    public void setCountry_Name(@NotNull String country_Name) {
        Country_Name = country_Name;
    }

    public Long getIso_code() {
        return iso_code;
    }

    public void setIso_code(Long iso_code) {
        this.iso_code = iso_code;
    }
}
