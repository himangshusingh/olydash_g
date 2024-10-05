package com.olympic.olydash.repository;
import com.olympic.olydash.domain.Medal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedalRepository extends JpaRepository<Medal, Long> {
    
}
