package ua.com.owu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.owu.dao.RegUserDAO;
import ua.com.owu.entity.RegUser;

@Service
@Transactional
public class RegUserServiceImpl implements RegUserService {

    @Autowired
    private RegUserDAO regUserDAO;

    public void save(RegUser regUser) {
        regUserDAO.save(regUser);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return regUserDAO.findByUsername(username);
    }
}
