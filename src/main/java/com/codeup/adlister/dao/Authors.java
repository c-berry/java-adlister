package com.codeup.adlister.dao;

import com.codeup.adlister.models.Author;

import java.util.List;

public interface Authors {
    List<Author> all();
    Author getOneAuthor(int id);
    Author getOneAuthorByName(String author_name);
    List<Author> searchAuthors(String query_string);
    long insert(Author author);
}