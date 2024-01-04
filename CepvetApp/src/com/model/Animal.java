package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Animal {

    private String animalId;
    private String breed;
    private String gender;
    private String age;

    public Animal(String animalId, String breed, String gender, String age) {
        this.animalId = animalId;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return animalId + "\t\t" + breed + "\t\t" + gender + "\t\t" + age;
    }

     public static Animal createAnimalFromResultSet(ResultSet rs) throws SQLException {
        // Implement logic to create Animal object from ResultSet data
        return new Animal(
                rs.getString("animal_id"),
                rs.getString("animal_gender"),
                rs.getString("animal_breed"),
                rs.getString("animal_age")
        );
    }
}

