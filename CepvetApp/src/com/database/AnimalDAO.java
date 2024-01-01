// Source code is decompiled from a .class file using FernFlower decompiler.
package com.database;

import com.model.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class AnimalDAO {
    
   private Animal animal;
   
    public AnimalDAO() {
    
    }

   public boolean addAnimal(Animal animal) {
      String sql = "insert into animal(animal_id, animal_name, animal_breeed, age) values(?, ?, ?, ?)";
      int rows = 0;

      try {
         Connection conn = DBConnectionManager.getConnection();
         Throwable var5 = null;

         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, animal.getAnimalId());
            ps.setString(2, animal.getName());
            ps.setString(3, animal.getBreed());
            ps.setString(4, animal.getGender());
            ps.setString(5, animal.getAge());
            rows = ps.executeUpdate();
         } catch (Throwable var15) {
            var5 = var15;
            throw var15;
         } finally {
            if (conn != null) {
               if (var5 != null) {
                  try {
                     conn.close();
                  } catch (Throwable var14) {
                     var5.addSuppressed(var14);
                  }
               } else {
                  conn.close();
               }
            }

         }
      } catch (SQLException var17) {
         var17.printStackTrace();
      }

      return rows > 0;
   }

    public boolean addSymptom(String animalId, int symptomId) {
        String sql = "INSERT INTO animal_symptoms(animal_id, symptom_id) VALUES(?, ?)";
        int rows = 0;

        try (Connection conn = DBConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animalId);
            ps.setInt(2, symptomId);
            rows = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public static List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals";
        List<Animal> animals = new ArrayList<>();

        try (Connection conn = DBConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                animals.add(animal.createAnimalFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animals;
    }

    public List<String> getSymptoms() {
        String sql = "SELECT symptom_id FROM animal_symptoms JOIN symptoms ON animal_symptoms.symptom_id = symptoms.symptom_id WHERE animal_id = ?";
        List<String> symptoms = new ArrayList<>();

        try (Connection conn = DBConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, animal.getAnimalId());
            
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                symptoms.add(rs.getString("symptom_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return symptoms;
    }

    public String determineDiagnosis() {
        String sql = "SELECT diagnosis_name FROM diagnoses JOIN diagnosis_symptoms ON diagnoses.diagnosis_id = diagnosis_symptoms.diagnosis_id JOIN symptoms ON diagnosis_symptoms.symptom_id = symptoms.symptom_id WHERE animal_id = ?";
        StringBuilder diagnosis = new StringBuilder("Diagnosis: ");
    
        try (Connection conn = DBConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
        
            ps.setString(1, animal.getAnimalId());
    
            ResultSet rs = ps.executeQuery();
    
            while (rs != null && rs.next()) {
                diagnosis.append(rs.getString("diagnosis_name")).append(", ");
            }
    
            // Remove the trailing comma and space
            if (diagnosis.length() > 12) {
                diagnosis.setLength(diagnosis.length() - 2);
            } else {
                // If no diagnosis is found
                diagnosis.append("Unknown");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return diagnosis.toString();
    }
    

    public void addSymptoms(String animalId, List<String> symptoms) {
        // JDBC Connection
        try (Connection connection = DBConnectionManager.getConnection()) {
            // SQL query to update symptoms for an animal
            String updateSymptomsQuery = "UPDATE animals SET symptoms = ? WHERE animal_id = ?";

            // Create PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSymptomsQuery)) {
                // Convert List<String> to a single string or format as needed
                String symptomsString = String.join(", ", symptoms);

                // Set parameters
                preparedStatement.setString(1, symptomsString);
                preparedStatement.setString(2, animalId);

                // Execute the update query
                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Symptoms added successfully.");
                } else {
                    System.out.println("Failed to add symptoms.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
    
}