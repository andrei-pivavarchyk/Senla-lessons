package com.journaldev.dao;

import com.journaldev.dao.api.IUserDataDAO;
import com.journaldev.model.User;
import com.journaldev.model.UserData;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataDAO extends BaseDAO<UserData> implements IUserDataDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public UserDataDAO() {
        super(UserData.class);
    }
    public UserData getDataByUser(User user){

       UserData userData = (UserData) getSession().createCriteria(UserData.class)
                .add(Restrictions.eq("user", user))
                .uniqueResult();
        return userData;

    }
}
