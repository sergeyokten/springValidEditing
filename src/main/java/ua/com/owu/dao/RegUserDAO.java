package ua.com.owu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.entity.RegUser;

public interface RegUserDAO extends JpaRepository<RegUser, Integer> {

    RegUser findByUsername(String username);
}
