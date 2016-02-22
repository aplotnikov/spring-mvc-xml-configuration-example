package org.home.spring.mvc.dao.country;

import org.home.spring.mvc.domain.Country;

import java.util.List;

public interface CountryDao {
    void insert(Country country);

    List<Country> selectAll();
}
