package com.olympic.olydash.repository;
import com.olympic.olydash.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
