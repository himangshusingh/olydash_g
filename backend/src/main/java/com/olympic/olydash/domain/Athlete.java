package com.olympic.olydash.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_Athlete")
public class Athlete{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long athlete_id;
    @Column
    @NotNull
    private String First_name;
    @Column
    @NotNull
    private String Last_name;
    @Column
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_name", referencedColumnName = "country_name", nullable = false)
    private Country country;
    @Column
    private String Gender;


    
    public Long getAthlete_id() {
        return athlete_id;
    }
    public void setAthlete_id(Long athlete_id) {
        this.athlete_id = athlete_id;
    }
    public String getFirst_name() {
        return First_name;
    }
    public void setFirst_name(String first_name) {
        First_name = first_name;
    }
    public String getLast_name() {
        return Last_name;
    }
    public void setLast_name(String last_name) {
        Last_name = last_name;
    }
    public @NotNull LocalDate getDate() {
        return date;
    }
    public void setDate(@NotNull LocalDate date) {
        this.date = date;
    }
    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }
    public String getGender() {
        return Gender;
    }
    public void setGender(String gender) {
        Gender = gender;
    }
}

