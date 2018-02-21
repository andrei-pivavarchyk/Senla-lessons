package com.serviceAPI;

import com.model.Author;

public interface IAuthorService {
    void addAuthor(Author author);
    void removeAuthor(Author author);
}