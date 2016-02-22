package org.home.spring.mvc.dao.country;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.home.spring.mvc.domain.Country;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class HsqlCountryDao extends JdbcDaoSupport implements CountryDao {
    private final static Log LOG = LogFactory.getLog(HsqlCountryDao.class);

    @Override
    public void insert(Country country) {
        if (country == null) {
            LOG.warn("Domain user is null!");
            return;
        }

        LOG.debug("Processing country: " + country);
        getJdbcTemplate().update("insert into country (name) values (?)", country.getName());
    }

    @Override
    public List<Country> selectAll() {
        return getJdbcTemplate().query("select id, name from country", new CountryMapper());
    }
}
