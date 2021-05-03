package com.example.PFA.rest;

import com.example.PFA.bean.Expert;
import com.example.PFA.bean.Projet;
import com.example.PFA.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/expert")
public class ExpertRest {


    @Autowired
    private ExpertService expertService;

    @GetMapping("login/{login}")
    public Expert findAdminByEmail(@PathVariable("login") String email) {
        return expertService.findExpertByLogin(email);
    }

    @PostMapping("register/")
    public int registerAdmin(@RequestBody Expert expert) {
        return expertService.registerExpert(expert);
    }

    @PostMapping("login/")
    public Expert loginAdmin(@RequestBody Expert expert) {
        Expert foundedExpert = expertService.loginExpert(expert.getLogin(), expert.getPassword());
        if (foundedExpert != null ){ 
            
           if(foundedExpert.getAnswers().equals("")) return expertService.loginExpert(expert.getLogin(), expert.getPassword());
           else throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Already answered"
            );
           }
        else
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "username or password wrong"
            );
    }
    @PutMapping("answer/")
    public int answer(@RequestBody Expert expert) {

        return expertService.answer(expert);
    }

}
