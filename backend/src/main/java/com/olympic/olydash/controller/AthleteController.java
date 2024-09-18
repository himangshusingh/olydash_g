package com.olympic.olydash.controller;

import com.olympic.olydash.repository.AthleteRepository;
import com.olympic.olydash.domain.Athlete;
// import org.apache.el.parser.AstGreaterThanEqual;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("athletes")
public class AthleteController {
    private AthleteRepository athleteRepository;

    public AthleteController(AthleteRepository athleteRepository){
        this.athleteRepository = athleteRepository;
    }


    @PostMapping("/saveathlete")
    public Athlete saveathlete(@RequestBody Athlete athlete){
        if(athlete.getId()==null){
            Athlete athlete1 = athleteRepository.save(athlete);
            return athlete1;
        }
        return null;
    }

    @PutMapping("/updateathlete")
    public Athlete updatebook(@RequestBody Athlete book){
        if(book.getId() != null){
            Athlete book1 = athleteRepository.save(book);
            return book1;
        }
        return null;
    }
    @GetMapping("/getAll")
    public List<Athlete> getAllAthletes(){
        return athleteRepository.findAll();

    }

    @GetMapping("/getbyid/{id}")
    public Athlete findbyid(@PathVariable Long id){
        Optional<Athlete> optional= athleteRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        athleteRepository.deleteById(id);
    }
}
