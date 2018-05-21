package ua.com.owu.service;

import ua.com.owu.entity.Customer;

public interface MailService {

    void sendEmail(Customer customer);
}
