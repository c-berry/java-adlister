package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Authors;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/author-search")
public class AuthorSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchString = req.getParameter("author_name");
        Authors authorsDao = DaoFactory.getAuthorsDao();
        List<Author> results = authorsDao.searchAuthors(searchString);
        req.setAttribute("results", results);
        req.getRequestDispatcher("/WEB-INF/quotes/authors-search.jsp").forward(req, resp);
    }
}