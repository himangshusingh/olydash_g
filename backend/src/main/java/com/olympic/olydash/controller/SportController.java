package com.olympic.olydash.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.olympic.olydash.domain.Sport;
import com.olympic.olydash.repository.SportRepository;

import java.util.List;

@RestController
@RequestMapping("sport")
public class SportController {
    private SportRepository sportRepository;

    public SportController(SportRepository sportRepository){
        this.sportRepository = sportRepository;
    }

    @PostMapping("/savesport")
    public Sport savesport(@RequestBody Sport sport){
        if(sport.getSport_id()==null){
            Sport sport1 = sportRepository.save(sport);
            return sport1;
        }
        return null;
    }

    @PutMapping("/updatesport")
    public Sport updateSport(@RequestBody Sport sport){
        if(sport.getSport_id()!=null){
            Sport sport1 = sportRepository.save(sport);
            return sport1;
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Sport> getallSport(){
        return sportRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletesport(@PathVariable Long sport_id){
        sportRepository.deleteById(sport_id);
    }
}
