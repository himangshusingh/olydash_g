package com.olympic.olydash.repository;
import com.olympic.olydash.domain.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

}
