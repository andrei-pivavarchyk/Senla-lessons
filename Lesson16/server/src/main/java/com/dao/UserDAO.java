package com.dao;

import com.dao.api.IUserDAO;
import com.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


public class UserDAO extends BaseDAO<User> implements IUserDAO {
    public UserDAO() {
        super(User.class);
    }

    private static Logger log = Logger.getLogger(UserDAO.class);

    public Boolean checkUser(User user) {
        try {
            Criteria criteria = getSession().createCriteria(User.class)
                    .add(Restrictions.like("login", user.getLogin()))
                    .add(Restrictions.like("password", user.getPassword()));
            User checkingUser = (User) criteria.uniqueResult();
            if (checkingUser != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error(e);
        }
        return false;
    }
}
