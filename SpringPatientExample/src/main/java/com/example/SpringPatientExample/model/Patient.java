package com.example.SpringPatientExample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Date;

@Document(collection = "patients")
public class Patient {
    @Id
    private String identifier;
    private boolean active;
    private String name;
    private String telecom;
    private String gender;
    private Date birthDate;
    private String address;
    private String maritalStatus;

    private List<Contact> contactList;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelecom() {
        return telecom;
    }

    public void setTelecom(String telecom) {
        this.telecom = telecom;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Patient(String identifier, boolean active, String name, String telecom, String gender, Date birthDate, String address, String maritalStatus, List<Contact> contactList) {
        this.identifier = identifier;
        this.active = active;
        this.name = name;
        this.telecom = telecom;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
        this.maritalStatus = maritalStatus;
        this.contactList = contactList;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "identifier='" + identifier + '\'' +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", telecom='" + telecom + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                // Include other fields here
                '}';
    }

}
