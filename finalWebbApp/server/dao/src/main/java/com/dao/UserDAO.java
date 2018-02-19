package com.dao;


import com.daoAPI.IUserDAO;
import com.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends BaseDAO<User> implements IUserDAO {

    public UserDAO() {
        super(User.class);
    }

    private static Logger log = Logger.getLogger(UserDAO.class);

    @Override
    public void addEntity(User entity) throws Exception {
            getSession().save(entity);
    }

    public Long checkUser(String login, String password) throws Exception {
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.like("login", login));
        User checkingUser = (User) criteria.uniqueResult();
        if (checkingUser != null) {
            return checkingUser.getId();
        }
        return null;
    }

    public User getUserByLoginPassword(String login, String password) throws Exception {
        Criteria criteria = getSession().createCriteria(User.class)
                .add(Restrictions.like("login", login))
                .add(Restrictions.like("password", password));
        User user = (User) criteria.uniqueResult();
        return user;
    }

    @Override
    public Session getSession() {
        return super.getSession();
    }
}

