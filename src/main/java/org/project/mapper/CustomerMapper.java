package org.project.mapper;

import org.project.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {
    public Customer map(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomer_name(resultSet.getString("customer_name"));
        customer.setPhone(resultSet.getLong("phone"));
        customer.setSum(resultSet.getInt("sum"));
        return customer;
    }
}
