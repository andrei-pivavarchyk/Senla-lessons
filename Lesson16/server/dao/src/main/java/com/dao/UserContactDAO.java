package com.dao;

import com.daoAPI.IUserContactDAO;
import com.model.User;
import com.model.UserContact;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by андрей on 19.02.2018.
 */
@Repository
public class UserContactDAO extends BaseDAO<UserContact> implements IUserContactDAO{

    public UserContactDAO(){
        super(UserContact.class);
    }



}
