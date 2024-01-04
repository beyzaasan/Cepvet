package com.model;

public class SymptomMedicine {
    private String symptomId;
    private String medicineId;

    // Constructors
    public SymptomMedicine() {
    }

    public SymptomMedicine(String symptomId, String medicineId) {
        this.symptomId = symptomId;
        this.medicineId = medicineId;
    }

    public String getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(String symptomId) {
        this.symptomId = symptomId;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    // toString() method for debugging purposes
    @Override
    public String toString() {
        return "Symptom medicine{" +
                "symptomId='" + symptomId + '\'' +
                ", medicineId='" + medicineId + '\'' +
                '}';
    }
}

