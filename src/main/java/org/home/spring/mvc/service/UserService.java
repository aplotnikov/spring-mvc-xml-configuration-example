package org.home.spring.mvc.service;

import org.home.spring.mvc.dao.user.UserDao;
import org.home.spring.mvc.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Service
@Transactional
public class UserService {
    private final UserDao userDao;

    @Inject
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true, propagation = SUPPORTS, isolation = READ_COMMITTED)
    public List<User> loadAllUsers() {
        return userDao.selectAll();
    }

    @Transactional(propagation = REQUIRES_NEW, isolation = SERIALIZABLE)
    public void saveUser(User user) {
        userDao.insert(user);
    }
}
