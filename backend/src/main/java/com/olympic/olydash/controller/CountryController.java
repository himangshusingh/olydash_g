package com.olympic.olydash.controller;

import com.olympic.olydash.domain.Country;
import com.olympic.olydash.repository.CountryRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("country")
public class CountryController {
    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }


    @PostMapping("/savecountry")
    public Country savecountry(@RequestBody Country country){
        if(country.getCountry_id()==null){
            Country country1 = countryRepository.save(country);
            return country1;
        }
        return null;
    }

    @PutMapping("/updatecountry")
    public Country updatecountry(@RequestBody Country country){
        if(country.getCountry_id()==null){
            Country country1 = countryRepository.save(country);
            return country1;
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Country> getAllCountry(){
        return countryRepository.findAll();
    }

    @DeleteMapping("/delete/{country_id}")
    public void deleteCountry(@PathVariable Long country_id){
        countryRepository.deleteById(country_id);
    }

}
