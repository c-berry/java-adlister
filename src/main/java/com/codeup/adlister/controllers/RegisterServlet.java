package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/ads/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        Users existingUser = DaoFactory.getUsersDao();


        if(username.length() >= 3
                && email.length() >= 3
//                && email.contains("@")
//                && email.contains(".")
                && password.length() >= 2
                && password.matches("[a-zA-z]+[0-9]+")){

            // TODO: create a new user based off of the submitted information

            User user = new User(username, email, password);
            DaoFactory.getUsersDao().insert(user);

            // TODO: if a user was successfully created, send them to their profile

            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUsername());
            response.sendRedirect("/profile");
        }

    }
} //end
