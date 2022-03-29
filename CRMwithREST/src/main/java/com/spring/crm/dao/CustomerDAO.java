package com.spring.crm.dao;

import com.spring.crm.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int custId);

    void deleteCustomer(int custId);
}
