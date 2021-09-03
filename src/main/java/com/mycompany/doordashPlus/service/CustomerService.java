package com.mycompany.doordashPlus.service;

import com.mycompany.doordashPlus.dao.CustomerDao;
import com.mycompany.doordashPlus.entity.Cart;
import com.mycompany.doordashPlus.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void signUp(Customer customer) {
        Cart cart = new Cart();
        customer.setCart(cart);

        customer.setEnabled(true);
        customerDao.signUp(customer);
    }

    public Customer getCustomer(String email) {
        return customerDao.getCustomer(email);
    }

}
