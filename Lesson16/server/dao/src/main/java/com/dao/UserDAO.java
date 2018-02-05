package com.dao;

import com.dao.api.IUserDAO;
import com.model.User;
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

    public Integer checkUser(String login,String password) throws Exception{
            Criteria criteria = getSession().createCriteria(User.class)
                    .add(Restrictions.like("login",login))
                    .add(Restrictions.like("password", password));
            User checkingUser = (User) criteria.uniqueResult();
            if (checkingUser != null) {
                return checkingUser.getId();
            } else {
                return null;
            }
    }

    public User getUserByLoginPassword(String login, String password) throws Exception {

            Criteria criteria = getSession().createCriteria(User.class)
                    .add(Restrictions.like("login", login))
                    .add(Restrictions.like("password", password));
            User user = (User) criteria.uniqueResult();
            return user;
        }
}

