package com.spring.crm.service;

import com.spring.crm.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int custId);

    void delete(int custId);
}
