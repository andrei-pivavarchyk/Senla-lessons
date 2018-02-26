package com.serviceAPI;

import com.model.Book;
import com.model.UserData;

import java.util.List;

public interface IUserDataService {

    void addUserData(UserData entity);

    UserData getUserDataByUserId(Integer id);

    void updateUserData(UserData entity);

    UserData getUserDataWithFavorites(Integer id);
}
