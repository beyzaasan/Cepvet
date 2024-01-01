package com.model;

public class Treatment {

    private String treatmentId;
    private String name;
    private String description;

    public Treatment(String treatmentId, String name, String description, double cost) {
        this.treatmentId = treatmentId;
        this.name = name;
        this.description = description;
    }

    public String getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(String treatmentId) {
        this.treatmentId = treatmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId + "\nName: " + name + "\nDescription: " + description;
    }
}

