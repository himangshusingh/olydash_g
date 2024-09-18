package com.olympic.olydash.repository;
import com.olympic.olydash.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event, Long>{

}

