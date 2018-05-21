package ua.com.owu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.CustomerDAO;
import ua.com.owu.entity.Customer;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerDAO customerDAO;

    public void save(Customer customer) {
        customerDAO.save(customer);

    }

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }
}
