package com.codeup.adlister.dao;

import com.codeup.adlister.models.Author;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsDao implements Authors{

    private Connection connection;

    public AuthorsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(),
                    config.getUser(),
                    config.getPassword());
        } catch (SQLException sqle){
            throw new RuntimeException("Error connecting to db", sqle);
        }
    }

    @Override
    public List<Author> all() {
        List<Author> authors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors");
            while (rs.next()){
                Author author = new Author(rs.getInt("id"), rs.getString("author_name"));
                authors.add(author);
            }
        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }
        return authors;
    }

    @Override
    public Author getOneAuthor(int id){
        Author author = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors WHERE id='" + id + "'");
            rs.next();
            author = new Author(rs.getInt("id"), rs.getString("author_name"));
        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }
        return author;
    }

    @Override
    public Author getOneAuthorByName(String author_name){
        Author author;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM codeup_test_db.authors WHERE author_name='" + author_name + "'");
            if (rs.next()) {
                return new Author(rs.getInt("id"), rs.getString("author_name"));
            } else {
                return null;
            }
        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }
    }

    @Override
    public List<Author> searchAuthors(String query_string){
        List<Author> searchResults = new ArrayList<>();
        try{

            String query = "SELECT * FROM codeup_test_db.authors WHERE author_name LIKE ?";
            String searchTerm = "%" + query_string + "%";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, searchTerm);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Author result = new Author(rs.getInt("id"), rs.getString("author_name"));
                searchResults.add(result);
            }
            return searchResults;
        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }
    }

    @Override
    public long insert(Author author) {
        String author_name = author.getAuthor_name();
        String query = "INSERT INTO codeup_test_db.authors (author_name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author_name);
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            rs.next();
            long key = rs.getLong(1);
            System.out.println("The key of the new insert is: " + key);
            return key;
        } catch (SQLException sqle){
            throw new RuntimeException("error connecting to db", sqle);
        }
    }
}