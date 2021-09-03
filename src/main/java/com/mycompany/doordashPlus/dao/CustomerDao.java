package com.mycompany.doordashPlus.dao;

import com.mycompany.doordashPlus.entity.Authorities;
import com.mycompany.doordashPlus.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();   // 开始了一个Transaction
            session.save(authorities);    // 定义了一些东西
            session.save(customer);       // 定义了..
            session.getTransaction().commit();    // commit后结束，保证atomic

        } catch (Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public Customer getCustomer(String email) {

        Customer customer = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            customer = session.get(Customer.class, email);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }

}
