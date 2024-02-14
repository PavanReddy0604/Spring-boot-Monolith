package com.app.service.impl;

import com.app.dao.PersonRepository;
import com.app.dto.PersonDTO;
import com.app.entity.Person;
import com.app.exception.BaseExcepiton;
import com.app.service.PersonService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    private PersonRepository personRepository;
    private ModelMapper modelMapper;
    public PersonServiceImpl(PersonRepository personRepository,ModelMapper modelMapper){
        this.personRepository=personRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public PersonDTO getPersonById(UUID uuid) {
        return null;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        return null;
    }

    @Override
    public int updatePerson(PersonDTO personDTO) {
        return 0;
    }

    @Override
    public void deletePerson(UUID uuid) {

    }

    @Override
    public int savePerson(PersonDTO personDTO) throws BaseExcepiton {
        int savedPersonId=0;
        try {
            personDTO.setPersonId(UUID.randomUUID());
            log.info("Saving Person with name {} ",personDTO.getPersonName());
            Person person=new Person();
            person.setPersonName(personDTO.getPersonName());
            person.setPersonId(personDTO.getPersonId());
            person.setMobileNumber(personDTO.getMobileNumber());
            person.setProject(personDTO.getProject());
            person.setGender(personDTO.getGender());
            person.setProof(personDTO.getIdProof());
            savedPersonId=personRepository.save(person).getId();
        }
        catch (Exception e){
            log.error("Exception occurred while saving the Person Record \n Error: {}",e.getMessage());
            throw new BaseExcepiton("Unable to save the person with name "+personDTO.getPersonName());
        }
        return savedPersonId;
    }
}
