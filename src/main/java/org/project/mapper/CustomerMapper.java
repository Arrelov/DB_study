package org.project.mapper;

import org.project.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {
    public Customer map(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomer_name(resultSet.getString(1));
        customer.setPhone(resultSet.getLong(2));
        customer.setSum(resultSet.getInt(3));
        return customer;
    }
}
