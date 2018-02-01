package com.dao.api;

import com.entity.User;
import com.entity.UserData;

public interface IUserDataDAO extends IBaseDAO<UserData> {
    UserData getDataByUser(User user);
}
