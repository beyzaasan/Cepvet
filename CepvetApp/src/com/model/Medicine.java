package com.model;

public class Medicine {

    private String medicineId;
    private String name;
    private String type;

    public Medicine(String medicineId, String name, String type, double price) {
        this.medicineId = medicineId;
        this.name = name;
        this.type = type;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Medicine ID: " + medicineId + "\nName: " + name + "\nType: " + type;
    }
}

