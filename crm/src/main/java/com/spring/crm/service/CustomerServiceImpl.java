package com.spring.crm.service;

import com.spring.crm.dao.CustomerDAO;
import com.spring.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int custId) {
        return customerDAO.getCustomer(custId);
    }

    @Override
    @Transactional
    public void delete(int custId) {
        customerDAO.deleteCustomer(custId);
    }
}
