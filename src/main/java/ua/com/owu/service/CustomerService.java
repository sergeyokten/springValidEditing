package ua.com.owu.service;


import ua.com.owu.entity.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);

    List<Customer> findAll();
}
