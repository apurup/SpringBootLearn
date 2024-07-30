package com.example.SpringPatientExample.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contacts")
public class Contact {

    private String relationship;
    private String name;
    private String telecom;
    private String address;
    private String gender;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Contact(String relationship, String name, String telecom, String address, String gender) {
        this.relationship = relationship;
        this.name = name;
        this.telecom = telecom;
        this.address = address;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "relationship='" + relationship + '\'' +
                ", name='" + name + '\'' +
                ", telecom='" + telecom + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                // Include other fields here
                '}';
    }
}
