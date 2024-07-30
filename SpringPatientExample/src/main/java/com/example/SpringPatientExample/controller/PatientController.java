package com.example.SpringPatientExample.controller;

import com.example.SpringPatientExample.exception.ContactNotFoundException;
import com.example.SpringPatientExample.exception.ResourceNotFoundException;
import com.example.SpringPatientExample.exception.SpecialCharecterFoundException;
import com.example.SpringPatientExample.exception.UnrecognizedGenderException;
import com.example.SpringPatientExample.model.Patient;
import com.example.SpringPatientExample.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private List<Patient> patients = new ArrayList<>();

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id) throws ResourceNotFoundException {

        System.out.println("provided patient id : "+ id);

        Patient patient = patientRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Patient with id "+id+" not found.")
        );



        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public  ResponseEntity<String> createPatient(@RequestBody Patient patient) throws SpecialCharecterFoundException, ContactNotFoundException, UnrecognizedGenderException {


        if ( patient.getName() == null){
            throw new NullPointerException("Patient name not given.");
        }
        if (patient.getGender() == null){
            throw new NullPointerException("Patient Gender not given.");
        }
        if (patient.getIdentifier() == null){
            throw new NullPointerException("Patient Identifier not given.");
        }
//        if(patient.isActive() == null){
//            throw new NullPointerException("Patient active status is not given");
//        }
        if(patient.getTelecom() == null){
            throw  new NullPointerException("Patient telecom is not given");
        }
        if(patient.getBirthDate() == null){
            throw new NullPointerException("Patient Birthdate not given");
        }
        String name = patient.getName();
        Pattern p = Pattern.compile(
                "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);


        // Creating matcher for above pattern on our string
        Matcher m = p.matcher(name);

        // Now finding the matches for which
        // let us set a boolean flag and
        // imposing find() method
        boolean res = m.find();

        if(res){
            throw new SpecialCharecterFoundException("Name should not have special characters: "+name);
        }

        if(patient.getContactList() == null || patient.getContactList().isEmpty()){
            throw  new ContactNotFoundException("Contacts list Cannot be empty.");
        }

        if ( !(patient.getGender().equalsIgnoreCase("Male") || patient.getGender().equalsIgnoreCase("Female"))){
            throw  new UnrecognizedGenderException("Gender Must be Male or Female.");
        }
        patientRepository.save(patient);
        return ResponseEntity.ok("Patient create successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable String id, @RequestBody Patient patient){

        patientRepository.save(patient);

        return ResponseEntity.ok("Patient updated successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Patient>> getAllPatients(){



        return ResponseEntity.ok(patientRepository.findAll());
    }


}
