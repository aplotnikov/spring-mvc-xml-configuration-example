package org.home.spring.mvc.dao.user;

import org.home.spring.mvc.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.home.spring.mvc.domain.User.Builder.anUser;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
        return anUser()
                .withId(
                        resultSet.getInt("id")
                )
                .withFirstName(
                        resultSet.getString("firstname")
                )
                .withLastName(
                        resultSet.getString("lastname")
                )
                .create();
    }
}