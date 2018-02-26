package com.serviceAPI;

import com.model.Book;
import com.model.UserData;

import java.util.List;

/**
 * Created by андрей on 26.02.2018.
 */
public interface IUserDataDTOService {
     UserData getUserDataDTO(UserData userData);
     List<Book> getBookList(List<Book> bookList);
}
