package com.model;

public class AnimalSymptoms {
    private String animalId;
    private String symptomId;

    // Constructors
    public AnimalSymptoms() {
    }

    public AnimalSymptoms(String animalId, String symptomId) {
        this.animalId = animalId;
        this.symptomId = symptomId;
    }

    // Getters and Setters
    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    // toString() method for debugging purposes
    @Override
    public String toString() {
        return "AnimalSymptom{" +
                "animalId='" + animalId + '\'' +
                ", symptomId='" + symptomId + '\'' +
                '}';
    }
}

