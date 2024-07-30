package com.example.SpringPatientExample.controller;

import com.example.SpringPatientExample.model.Patient;
import com.example.SpringPatientExample.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private List<Patient> patients = new ArrayList<>();

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable String id){

        System.out.println("provided patient id : "+ id);

        Patient patient = patientRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Patient not found")
        );



        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public  ResponseEntity<String> createPatient(@RequestBody Patient patient){

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
