package com.dao;

import com.daoAPI.IUserDataDAO;
import com.model.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDataDAO extends BaseDAO<UserData> implements IUserDataDAO {

    public UserDataDAO() {
        super(UserData.class);
    }

    public UserData getDataByUser(User user)throws Exception {
        UserData userData = (UserData) getSession().createCriteria(UserData.class, "ud")
                .add(Restrictions.eq("user", user))
                .uniqueResult();
        return userData;
    }


    public UserData getUserDatawithFavoritesBooks(User user) throws Exception{
        Criteria criteria = getSession().createCriteria(UserData.class, "ud")
                .add(Restrictions.eq("user", user))
                .createAlias("ud.favorites", "favorites", JoinType.LEFT_OUTER_JOIN);
        return (UserData)criteria.uniqueResult();
    }

    public UserData getUserDatawithAllDetails(User user) throws Exception{
        Criteria criteria = getSession().createCriteria(UserData.class, "ud")
                .add(Restrictions.eq("user", user))
                .createAlias("ud.favorites", "favorites", JoinType.LEFT_OUTER_JOIN)
                .createAlias("ud.feedbackList", "feedbackList", JoinType.RIGHT_OUTER_JOIN)
                ;
        return (UserData)criteria.uniqueResult();
    }

}
