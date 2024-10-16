package com.olympic.olydash.controller;

import com.olympic.olydash.repository.EventRepository;
import com.olympic.olydash.domain.Event;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("events")
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @PostMapping("/saveevent")
    public Event saveEvent(@RequestBody Event event) {
        if (event.getevent_id() ==null) {
            return eventRepository.save(event);
        }
        return null;
    }

    @PutMapping("/updateevent")
    public Event updateEvent(@RequestBody Event event) {
        if (event.getevent_id() != null) {
            return eventRepository.save(event);
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/getbyid/{id}")
    public Event findById(@PathVariable Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
}
