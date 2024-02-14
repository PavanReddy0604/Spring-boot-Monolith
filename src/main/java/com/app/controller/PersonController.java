package com.app.controller;

import com.app.dto.PersonDTO;
import com.app.exception.BaseExcepiton;
import com.app.service.impl.PersonServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonServiceImpl personService;
    public PersonController(PersonServiceImpl personService){
        this.personService=personService;
    }

    @PostMapping("/")
    public ResponseEntity<Integer> savePerson(@RequestBody()PersonDTO personDTO) throws BaseExcepiton {
        int id=personService.savePerson(personDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
