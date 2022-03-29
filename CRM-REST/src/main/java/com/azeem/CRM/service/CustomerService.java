package com.azeem.CRM.service;

import com.azeem.CRM.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer theCustomer);
    List<Customer> getCustomers();
    Customer getCustomer(int theId);
    void deleteCustomer(int theId);
}
