package com.mkyong.common.controller.dao;

import com.mkyong.common.controller.User;
import com.mkyong.common.controller.dao.BaseDAO;
import com.mkyong.common.controller.dao.IUserDAO;


public class UserDAO extends BaseDAO<User> implements IUserDAO {
    public UserDAO() {
        super(User.class);
    }
}
