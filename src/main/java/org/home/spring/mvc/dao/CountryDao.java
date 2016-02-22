package org.home.spring.mvc.dao;

import org.home.spring.mvc.domain.Country;

import java.util.List;

public interface CountryDao {
    void insert(Country country);

    Country select(int id);

    List<Country> selectAll();
}
