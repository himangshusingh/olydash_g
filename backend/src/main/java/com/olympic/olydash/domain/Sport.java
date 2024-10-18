package com.olympic.olydash.domain;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "TBL_Sport")
public class Sport {

    @Id
    @NotNull 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sport_id;
    
    @Column @NotNull
    private String sport_name;

    public Long getSport_id() {
        return sport_id;
    }

    public void setSport_id(Long sport_id) {
        this.sport_id = sport_id;
    }

    public String getSport_name() {
        return sport_name;
    }

    public void setSport_name(String sport_name) {
        this.sport_name = sport_name;
    }

    
}
