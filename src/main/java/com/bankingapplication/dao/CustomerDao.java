package com.bankingapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bankingapplication.entity.Customer;

public class CustomerDao {
	
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    public Customer saveCustomer(Customer customer) {
        et.begin();
        em.persist(customer);
        et.commit();
        return customer;
    }

    public Customer findCustomer(int customerId) {
        Customer customer = em.find(Customer.class, customerId);
        return customer;
    }

    public Customer deleteCustomer(int customerId) {
        Customer customer = em.find(Customer.class, customerId);
        if (customer != null) {
            et.begin();
            em.remove(customer);
            et.commit();
            return customer;
        }
        return null;
    }

    public Customer updateCustomer(Customer customer, int customerId) {
        Customer dbCustomer = em.find(Customer.class, customerId);
        if (dbCustomer != null) {
            customer.setCustomerId(customerId);
            et.begin();
            em.merge(customer);
            et.commit();
            return customer;
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createQuery("SELECT c FROM Customer c");
        List<Customer> allCustomers = query.getResultList();
        return allCustomers;
    }

}
