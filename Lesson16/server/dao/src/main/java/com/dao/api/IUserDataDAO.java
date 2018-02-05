package com.dao.api;

import com.model.User;
import com.model.UserData;

public interface IUserDataDAO extends IBaseDAO<UserData> {
    UserData getDataByUser(User user);
}
