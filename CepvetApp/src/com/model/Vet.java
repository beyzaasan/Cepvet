package com.model;

public class Vet {

    private String vetId;
    private String name;
    private String specialization;
    private String contact;

    public Vet(String vetId, String name, String specialization, String contact) {
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.contact = contact;
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Vet ID: " + vetId + "\nName: " + name + "\nSpecialization: " + specialization + "\nContact: " + contact;
    }
}

