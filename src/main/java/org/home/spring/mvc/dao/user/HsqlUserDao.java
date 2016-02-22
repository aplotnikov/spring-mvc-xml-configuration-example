package org.home.spring.mvc.dao.user;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.home.spring.mvc.domain.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class HsqlUserDao extends JdbcDaoSupport implements UserDao {
    private final static Log LOG = LogFactory.getLog(HsqlUserDao.class);

    @Override
    public void insert(User user) {
        if (user == null) {
            LOG.warn("Domain user is null!");
            return;
        }

        LOG.debug("Processing user: " + user);

        getJdbcTemplate()
                .update(
                        "insert into user (firstname, lastname) values (?, ?)",
                        user.getFirstName(),
                        user.getLastName()
                );
    }

    @Override
    public List<User> selectAll() {
        return getJdbcTemplate().query("select id, firstname, lastname from user", new UserMapper());
    }
}