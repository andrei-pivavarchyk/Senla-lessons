package com.service.dtoService;

import com.daoAPI.IUserDAO;
import com.daoAPI.IUserDataDAO;
import com.model.*;
import com.serviceAPI.IUserDataDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by андрей on 26.02.2018.
 */
@Service
@Transactional
public class UserDataDTOService implements IUserDataDTOService {

    @Autowired
    private IUserDataDAO userDataDao;
    @Autowired
    private IUserDAO userDao;


    public UserDataDTOService() {
    }


    @Override
    public UserData getUserDataDRO(UserData userData) {

        UserData dto = new UserData();
        String str = userData.getRole().toString();
        dto.setRole(Role.valueOf(str));
        dto.setName(userData.getName());
        dto.setSurname(userData.getSurname());
        dto.setPatronymic(userData.getPatronymic());
        dto.setEmail(userData.getEmail());
        dto.setPhone(userData.getPhone());
        dto.setAddress(userData.getAddress());
        Address address = dto.getAddress();
        address.setCity(userData.getAddress().getCity());
        address.setCountry(userData.getAddress().getCountry());
        address.setIndex(userData.getAddress().getIndex());
        address.setRegion(userData.getAddress().getRegion());
        address.setStreet(userData.getAddress().getStreet());

        return dto;
    }

    public List<Book> getFavoriteBookList(List<Book> bookList) {
        List<Book>userDataBookList=new ArrayList<>();


        for (Book book : bookList) {

            Book book2 = new Book();
          // book2.setAuthor(book.getAuthor());
            book2.setBookCost(book.getBookCost());
            book2.setBookDescription(book.getBookDescription());
            book2.setBookName(book.getBookName());
            book2.setBookStatus(book.getBookStatus());
            userDataBookList.add(book2);
        }
        return userDataBookList;
    }
}
