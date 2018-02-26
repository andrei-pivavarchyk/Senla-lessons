package com.service;

import com.daoAPI.IAuthorDAO;
import com.model.Author;
import com.serviceAPI.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorDAO authorDAO;

    public AuthorService() {
    }


    public void addAuthor(Author author) {
        try {
            this.authorDAO.addEntity(author);
        } catch (Exception e) {
        }
    }

    public void removeAuthor(Author author) {
        try {
            this.authorDAO.deleteEntity(author.getId());
        } catch (Exception e) {

        }
    }

    public List<Author> getAllAuthors(){
        List<Author> allAuthors=this.authorDAO.getAllAuthors();
        return allAuthors;
    }
}