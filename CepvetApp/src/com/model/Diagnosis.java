package com.model;

import java.util.List;

public class Diagnosis {

    private String animalId;
    private List<String> symptoms;
    private String possibleSickness;

    public Diagnosis(String animalId, List<String> symptoms, String possibleSickness) {
        this.animalId = animalId;
        this.symptoms = symptoms;
        this.possibleSickness = possibleSickness;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public String getPossibleSickness() {
        return possibleSickness;
    }

    public void setPossibleSickness(String possibleSickness) {
        this.possibleSickness = possibleSickness;
    }

    @Override
    public String toString() {
        return "Animal ID: " + animalId + "\nSymptoms: " + symptoms + "\nPossible Sickness: " + possibleSickness;
    }
}

