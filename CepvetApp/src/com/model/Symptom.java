package com.model;

public class Symptom {

    private String symptomId;
    private String name;

    public Symptom(String symptomId, String name) {
        this.symptomId = symptomId;
        this.name = name;
    }

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Symptom ID: " + symptomId + "\nName: " + name;
    }
}

