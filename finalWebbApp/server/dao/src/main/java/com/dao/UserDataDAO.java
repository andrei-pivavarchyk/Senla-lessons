package com.dao;

import com.daoAPI.IUserDataDAO;
import com.model.User;
import com.model.UserData;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataDAO extends BaseDAO<UserData> implements IUserDataDAO {

    public UserDataDAO() {
        super(UserData.class);
    }

    public UserData getDataByUser(User user) {
        UserData userData = (UserData) getSession().createCriteria(UserData.class)
                .add(Restrictions.eq("user", user))
                .uniqueResult();
        return userData;
    }
}
