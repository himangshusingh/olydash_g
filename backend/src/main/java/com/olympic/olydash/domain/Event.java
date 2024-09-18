package com.olympic.olydash.domain;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "TBL_Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column @NotNull
    private String event_name;
    @Column
    private String event_type_id;

    public Long geteventId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(@NotNull String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_type_id() {
        return event_type_id;
    }

    public void setEvent_type_id(String event_type_id) {
        this.event_type_id = event_type_id;
    }
}
