package com.serviceAPI;

import com.model.UserData;

public interface IUserDataService {

    void addUserData(UserData entity);

    UserData getUserDataByUserId(Integer id);

    void updateUserData(UserData entity);
}
