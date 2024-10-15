package com.olympic.olydash.domain;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_Medal")
public class Medal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medal_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "athlete_id", referencedColumnName = "athlete_id", nullable = true)
    private Athlete athlete;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "event_id", nullable = true)
    private Event event;

    @Column
    @NotNull
    private String medal_type;
    @Column
    @NotNull
    private LocalDate Date;


    public Long getMedal_id() {
        return medal_id;
    }
    public void setMedal_id(Long medal_id) {
        this.medal_id = medal_id;
    }
    public Athlete getAthlete() {
        return athlete;
    }
    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }
    public Event getEvent() {
        return event;
    }
    public void setEvent(Event event) {
        this.event = event;
    }
    public String getMedal_type() {
        return medal_type;
    }
    public void setMedal_type(String medal_type) {
        this.medal_type = medal_type;
    }
    public LocalDate getDate() {
        return Date;
    }
    public void setDate(LocalDate date) {
        this.Date = date;
    }
}
