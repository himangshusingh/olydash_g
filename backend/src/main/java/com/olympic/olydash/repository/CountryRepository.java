package com.olympic.olydash.repository;

import com.olympic.olydash.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
