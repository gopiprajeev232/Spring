package com.spring.crm.dao;

import com.spring.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();

        List<Customer> customers = session.createQuery("from Customer order by lastName", Customer.class).getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int custId) {
        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, custId);

        return customer;
    }

    @Override
    public void deleteCustomer(int custId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:customerId").setParameter("customerId", custId);

        query.executeUpdate();
    }
}
