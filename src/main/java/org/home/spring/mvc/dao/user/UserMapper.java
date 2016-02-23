package org.home.spring.mvc.dao.user;

import org.home.spring.mvc.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
        User user = new User();

        user.setId(
                resultSet.getInt("id")
        );
        user.setFirstName(
                resultSet.getString("firstname")
        );
        user.setLastName(
                resultSet.getString("lastname")
        );

        return user;
    }
}