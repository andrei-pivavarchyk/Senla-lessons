package com.dao;

import com.dao.api.IUserDAO;
import com.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
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

    public User getUserByLoginPassword(String login, String password) {

        try {
            Criteria criteria = getSession().createCriteria(User.class)
                    .add(Restrictions.like("login", login))
                    .add(Restrictions.like("password", password));
            User user = (User) criteria.uniqueResult();
            return user;

        } catch (Exception e) {
            log.error(e);
            return null;
        }

    }



}

