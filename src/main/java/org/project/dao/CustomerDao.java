package org.project.dao;

import lombok.RequiredArgsConstructor;
import org.project.entity.Customer;
import org.project.mapper.CustomerMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CustomerDao {
    private final Connection connection;
    private final CustomerMapper mapper;

    public List<Customer> findAll() throws SQLException {
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(
                "SELECT\n" +
                "\tcustomer.name AS customer_name,\n" +
                "\tcustomer.phone AS phone,\n" +
                "\tSUM(price) AS sum\n" +
                "FROM\n" +
                "\tcustomer\n" +
                "\tINNER JOIN customer_orders ON customer.id = customer_orders.customer_id\n" +
                "\tINNER JOIN orders ON customer_orders.order_id = orders.id\n" +
                "GROUP BY\n" +
                "\tcustomer_name,\n" +
                "\tphone\n" +
                "ORDER BY \n" +
                "\tsum DESC;");

        List<Customer> customers = new ArrayList<>();
        while (resultSet.next()) {
            customers.add(mapper.map(resultSet));
        }
        return customers;
    }
}
