package com.heshanthenura.crudapi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBServices {

    @Autowired
    PersonRepository personRepository;

    public List<PersonEntity> getAllPeople(){
        return personRepository.findAll();
    }

    public PersonEntity getPersonById(Long id){
        return personRepository.findById(id).get();
    }

    public void savePerson(PersonEntity person){
        personRepository.save(person);
    }
    public void deletePerson(Long id){
        personRepository.deleteById(id);
    }
}
