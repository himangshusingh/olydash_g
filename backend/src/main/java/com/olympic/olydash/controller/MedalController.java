package com.olympic.olydash.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olympic.olydash.domain.Medal;
import com.olympic.olydash.repository.MedalRepository;

import java.util.List;

@RestController
@RequestMapping("medal")
public class MedalController {

    private MedalRepository medalRepository;

    public MedalController(MedalRepository medalRepository){
        this.medalRepository = medalRepository;
    }

    @PostMapping("/savemedal")
    public Medal savemedal(@RequestBody Medal medal){
        if(medal.getMedal_id()==null){
            return medalRepository.save(medal);
        }
        return null;
    }

    @PutMapping("/updatemedal")
    public Medal updateMedal(@RequestBody Medal medal){
        if(medal.getMedal_id()!=null){
            Medal medal1 = medalRepository.save(medal);
            return medal1;
        }
        return null;
    }

    @GetMapping("/getAll")
    public List<Medal> getallMedal(){
        return medalRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletemedal(@PathVariable Long medal_id){
        medalRepository.deleteById(medal_id);
    }
    
}
