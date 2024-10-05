package com.olympic.olydash.domain;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_Medal")
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medal_id;
    @Column
    @NotNull
    private String medal_type;
    @Column
    private String Date;
    public Long getMedal_id() {
        return medal_id;
    }
    public void setMedal_id(Long medal_id) {
        this.medal_id = medal_id;
    }
    public String getMedal_type() {
        return medal_type;
    }
    public void setMedal_type(String medal_type) {
        this.medal_type = medal_type;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }
    
    
}
