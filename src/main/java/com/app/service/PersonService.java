package com.app.service;

import com.app.dto.PersonDTO;
import com.app.entity.Person;
import com.app.exception.BaseExcepiton;

import java.util.List;
import java.util.UUID;

public interface PersonService {

    PersonDTO getPersonById(UUID uuid);
    List<PersonDTO> getAllPersons();
    int updatePerson(PersonDTO personDTO);
    void deletePerson(UUID uuid);

    int savePerson(PersonDTO personDTO) throws BaseExcepiton;


}
