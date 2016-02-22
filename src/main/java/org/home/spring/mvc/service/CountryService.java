package org.home.spring.mvc.service;

import org.home.spring.mvc.dao.country.CountryDao;
import org.home.spring.mvc.domain.Country;
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
public class CountryService {
    private final CountryDao countryDao;

    @Inject
    public CountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Transactional(readOnly = true, propagation = SUPPORTS, isolation = READ_COMMITTED)
    public List<Country> loadAllCountries() {
        return countryDao.selectAll();
    }

    @Transactional(propagation = REQUIRES_NEW, isolation = SERIALIZABLE)
    public void saveCountry(Country country) {
        countryDao.insert(country);
    }
}
