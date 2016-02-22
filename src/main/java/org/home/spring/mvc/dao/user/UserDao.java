package org.home.spring.mvc.dao.user;

import org.home.spring.mvc.domain.User;

import java.util.List;

public interface UserDao {
    void insert(User user);

    List<User> selectAll();
}
