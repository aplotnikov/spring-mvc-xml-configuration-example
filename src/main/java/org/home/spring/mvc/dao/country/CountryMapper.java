package org.home.spring.mvc.dao.country;

import org.home.spring.mvc.domain.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int rowIndex) throws SQLException {
        return new Country(
                resultSet.getInt("id"),
                resultSet.getString("name")
        );
    }
}
