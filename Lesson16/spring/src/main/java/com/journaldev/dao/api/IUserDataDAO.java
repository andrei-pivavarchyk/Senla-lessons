package com.journaldev.dao.api;

import com.journaldev.model.User;
import com.journaldev.model.UserData;

public interface IUserDataDAO extends IBaseDAO<UserData> {
    UserData getDataByUser(User user);
}
