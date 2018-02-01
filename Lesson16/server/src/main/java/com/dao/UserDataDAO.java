package com.dao;

import com.dao.api.IUserDataDAO;
import com.entity.UserData;

public class UserDataDAO extends BaseDAO<UserData> implements IUserDataDAO{
    public UserDataDAO() {
        super(UserData.class);
    }
}
