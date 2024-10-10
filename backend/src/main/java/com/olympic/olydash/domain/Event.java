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

@Entity
@Table(name = "TBL_Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long event_id;
    @Column @NotNull
    private String event_name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sport_id", referencedColumnName = "sport_id", nullable = false)
    private Sport sport;

    @Column
    private String event_type_id; //this will be a foreign key, events_id_table_pending

    public Long geteventId() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public @NotNull String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(@NotNull String event_name) {
        this.event_name = event_name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(String event_type_id) {
        this.event_type_id = event_type_id;
    }
}
