package ua.com.owu.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ua.com.owu.entity.RegUser;

public interface RegUserService extends UserDetailsService {

    void save(RegUser regUser);
}
