package com.daoAPI;

import com.daoAPI.IBaseDAO;
import com.model.Book;
import com.model.User;
import com.model.UserData;

import java.util.List;

public interface IUserDataDAO extends IBaseDAO<UserData> {
    UserData getDataByUser(User user) throws Exception;

    UserData getUserDatawithFavoritesBooks(User user) throws Exception;
    UserData getUserDatawithAllDetails(User user) throws Exception;
}
