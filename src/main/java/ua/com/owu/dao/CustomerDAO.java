package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

//    @Modifying
//    @Query("select c from Customer c where c.email =:x")
//    List<Customer> xxxx(@Param("x") String email);
//
//    List<Customer> findAllByEmail(String email);



}
