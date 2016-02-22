package org.home.spring.mvc.service;

import org.home.spring.mvc.dao.CountryDao;
import org.home.spring.mvc.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountryService {

    private CountryDao countryDao;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
    public List<Country> loadAllCountries() {
        return countryDao.selectAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void saveCountry(Country country) {
        countryDao.insert(country);
    }

    public CountryDao getUserDao() {
        return countryDao;
    }

    @Autowired
    @Required
    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

}
