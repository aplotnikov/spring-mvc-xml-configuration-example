package org.home.spring.mvc.dao;

import org.home.spring.mvc.domain.User;

import java.util.List;

public interface UserDao {
    void insert(User user);

    User select(int id);

    List<User> selectAll();
}
