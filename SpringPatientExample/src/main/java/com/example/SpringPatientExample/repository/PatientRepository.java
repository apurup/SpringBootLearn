package com.example.SpringPatientExample.repository;

import com.example.SpringPatientExample.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PatientRepository  extends MongoRepository<Patient, String> {

}
