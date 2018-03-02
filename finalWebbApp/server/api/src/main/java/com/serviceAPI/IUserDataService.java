package com.serviceAPI;

import com.model.Book;
import com.model.Order;
import com.model.UserData;

import java.util.List;

public interface IUserDataService {

    void addUserData(UserData entity);

    UserData getUserDataByUserId(Integer id);

    void updateUserData(UserData entity);

    UserData getUserDataWithFavorites(Integer id);
    List<UserData> getAllUserData();
    void addBookToCart(Integer userID,Book book);

}
