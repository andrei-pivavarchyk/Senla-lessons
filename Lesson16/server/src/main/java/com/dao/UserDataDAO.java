package com.dao;

import com.dao.api.IUserDataDAO;
import com.entity.User;
import com.entity.UserData;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class UserDataDAO extends BaseDAO<UserData> implements IUserDataDAO{
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
