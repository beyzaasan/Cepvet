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
      String sql = "insert into animals(animal_id, animal_gender, animal_type, animal_age) values(?, ?, ?, ?)";
      int rows = 0;

      try {
         Connection conn = DBConnectionManager.getConnection();
         Throwable var5 = null;

         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, animal.getAnimalId());
            ps.setString(2, animal.getGender());
            ps.setString(3, animal.getBreed());
            ps.setString(4, animal.getAge());
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

    public void addSymptoms(String animalId, List<String> symptoms) {
        // JDBC Connection
        try (Connection connection = DBConnectionManager.getConnection()) {
            // SQL query for inserting into animal_symptoms
            String insertAnimalSymptomsQuery = "INSERT INTO animal_symptoms (animal_id, symptom_id) VALUES (?, ?)";
    
            // Create PreparedStatement
            try (PreparedStatement insertAnimalSymptomsStatement = connection.prepareStatement(insertAnimalSymptomsQuery)) {
                for (String symptom : symptoms) {
                    // SQL query for fetching symptom_id based on symptom_name
                    String selectSymptomIdQuery = "SELECT symptom_id FROM symptoms WHERE LOWER(symptom_name) = LOWER(?)";
    
                    // Create PreparedStatement
                    try (PreparedStatement selectStatement = connection.prepareStatement(selectSymptomIdQuery)) {
                        // Set parameter for case-insensitive symptom_name in the SELECT query
                        selectStatement.setString(1, symptom);
    
                        // Debugging statements
                        System.out.println("Executing query: " + selectSymptomIdQuery);
                        System.out.println("With parameters: symptom=" + symptom);
    
                        // Execute the SELECT query to get the symptom_id
                        ResultSet resultSet = selectStatement.executeQuery();
    
                        if (resultSet.next()) {
                            // Get the symptom_id from the result set
                            String symptomId = resultSet.getString("symptom_id");
    
                            // Set parameters for the INSERT query into animal_symptoms
                            insertAnimalSymptomsStatement.setString(1, animalId);
                            insertAnimalSymptomsStatement.setString(2, symptomId);
    
                            // Debugging statement
                            System.out.println("Executing query: " + insertAnimalSymptomsQuery);
                            System.out.println("With parameters: animal_id=" + animalId + ", symptom_id=" + symptomId);
    
                            // Execute the INSERT query into animal_symptoms
                            int rowsInserted = insertAnimalSymptomsStatement.executeUpdate();
    
                            // Check if the insert was successful
                            if (rowsInserted > 0) {
                                System.out.println("Symptom '" + symptom + "' added successfully for animal '" + animalId + "'.");
                            } else {
                                System.out.println("Failed to add symptom '" + symptom + "' for animal '" + animalId + "'.");
                            }
                        } else {
                            System.out.println("Symptom not found: " + symptom);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public static List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals";
        List<Animal> animals = new ArrayList<>();
    
        try (Connection conn = DBConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
    
            while (rs != null && rs.next()) {
                // Create an instance of the Animal class using the constructor
                Animal animal = new Animal(
                    rs.getString("animal_id"),
                    rs.getString("animal_gender"),
                    rs.getString("animal_type"),
                    rs.getString("animal_age")
                );
                animals.add(animal);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return animals;
    }
    
    

    public List<String> getSymptoms() {
        String sql = "SELECT symptom_id FROM animals JOIN symptoms ON animal_symptoms.symptom_id = symptoms.symptom_id WHERE animal_id = ?";
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
    
    public String determineMedicine(String diagnosis) {
        String sql = "SELECT medicine_name FROM medicines " +
                "JOIN diagnosis_medicines ON medicines.medicine_id = diagnosis_medicines.medicine_id " +
                "JOIN diagnosis ON diagnosis_medicines.diagnosis_id = diagnosis.diagnosis_id " +
                "WHERE diagnosis.diagnosis_name = ?";
    
        StringBuilder medicineInfo = new StringBuilder("Medicine: ");
    
        try (Connection conn = DBConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
    
            ps.setString(1, diagnosis);
    
            ResultSet rs = ps.executeQuery();
    
            while (rs != null && rs.next()) {
                medicineInfo.append(rs.getString("medicine_name")).append(", ");
            }
    
            // ------>>>>>>>>>>>>>>>>>> burayı tamamen değiştirebilirsiniz

            if (medicineInfo.length() > 9) {
                medicineInfo.setLength(medicineInfo.length() - 2);
            } else {
                // If no medicine is found for the diagnosis
                medicineInfo.append("No specific medicine found for the diagnosis.");
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return medicineInfo.toString();
    }
    
    
    
}