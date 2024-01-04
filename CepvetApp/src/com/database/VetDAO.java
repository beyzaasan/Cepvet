package com.database;

import com.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VetDAO {

    // You need to have your own method to get a database connection
    // For simplicity, I'm assuming you have a class like DBConnectionManager

    public List<Vet> getVetList() {
        List<Vet> vets = new ArrayList<>();

        // JDBC Connection
        try (Connection connection = DBConnectionManager.getConnection()) {
            // SQL query to retrieve vet information
            String getVetListQuery = "SELECT * FROM vets";

            // Create PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(getVetListQuery)) {
                // Execute the query
                ResultSet resultSet = preparedStatement.executeQuery();

                // Process the ResultSet and create Vet objects
                while (resultSet.next()) {
                    String vetId = resultSet.getString("vet_id");
                    String name = resultSet.getString("vet_name");
                    String specialization = resultSet.getString("specialization");
                    String contact = resultSet.getString("contact");

                    Vet vet = new Vet(vetId, name, specialization, contact);
                    vets.add(vet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }

        return vets;
    }
}

