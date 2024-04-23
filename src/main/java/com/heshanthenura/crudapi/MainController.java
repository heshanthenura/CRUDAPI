package com.heshanthenura.crudapi;

import com.heshanthenura.crudapi.database.DBServices;
import com.heshanthenura.crudapi.database.PersonEntity;
import com.sun.jdi.event.ExceptionEvent;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    DBServices dbServices;

    //Get all people
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PersonEntity> getAllPeople() {
        return dbServices.getAllPeople();
    }

    //Add a person
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addPerson(@Valid @RequestBody PersonEntity person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        } else {
            dbServices.savePerson(person);
            return ResponseEntity.ok("Person added successfully : " + person.toString());
        }
    }

    // Update a person
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatePerson(@PathVariable("id") Long id, @Valid @RequestBody PersonEntity updatedPerson, BindingResult bindingResult) {
        try {
            PersonEntity existingPerson = dbServices.getPersonById(id);
            if (existingPerson == null) {
                return ResponseEntity.badRequest().body("Person not found with ID: " + id);
            }

            if (bindingResult.hasErrors()) {
                return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
            }

            existingPerson.setFname(updatedPerson.getFname());
            existingPerson.setLname(updatedPerson.getLname());
            existingPerson.setAge(updatedPerson.getAge());

            dbServices.savePerson(existingPerson);
            return ResponseEntity.ok("Person updated successfully: " + existingPerson.toString());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update person: " + e.getMessage());
        }
    }


    //Delete a person
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePerson(@PathVariable("id") Long id) {
        try {
            dbServices.getPersonById(id);
            dbServices.deletePerson(id);
            return ResponseEntity.ok("Person deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
