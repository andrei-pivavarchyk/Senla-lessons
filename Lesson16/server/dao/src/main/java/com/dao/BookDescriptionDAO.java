package com.dao;

import com.daoAPI.IBookDAO;
import com.daoAPI.IBookDescriptionDAO;
import com.model.BookDescription;

public class BookDescriptionDAO extends BaseDAO<BookDescription> implements IBookDescriptionDAO{

    public BookDescriptionDAO(Class clazz) {
        super(clazz);
    }
}
