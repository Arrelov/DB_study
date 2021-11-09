package org.project;

import org.project.dao.CustomerDao;
import org.project.entity.Customer;
import org.project.mapper.CustomerMapper;

import java.sql.*;
import java.util.List;

public class AppPostgreSQL {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/customer";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "0000";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            CustomerMapper customerMapper = new CustomerMapper();
            CustomerDao customerDao = new CustomerDao(connection, customerMapper);

            final List<Customer> people = customerDao.findAll();

            System.out.println("\tTask: Find customer's name, customer's phone and orders sum of all his orders ");
            System.out.println("\t \t \tand sort it's by sum (from biggest sum to smallest sum):");
            System.out.println("\tSolution:");
            for (Customer customer: people) {
                System.out.println(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
