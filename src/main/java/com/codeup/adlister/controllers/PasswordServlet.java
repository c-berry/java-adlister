package com.codeup.adlister.controllers;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordServlet {

    public static void main(String[] args) {
        String pass = "password";
        String hash = BCrypt.hashpw(pass, BCrypt.gensalt(16));
        System.out.println(hash);

        String salt = BCrypt.gensalt(12);
        System.out.println(salt);
        System.out.println("1: " + BCrypt.hashpw("password", salt));
        System.out.println("2: " + BCrypt.hashpw("password", salt));
        System.out.println(BCrypt.hashpw("yoyoyo", salt));


        String hash2 = BCrypt.hashpw("password123", BCrypt.gensalt(10));
        boolean match = BCrypt.checkpw("password", hash2);
        boolean match2 = BCrypt.checkpw("password123", hash2);
        System.out.println(match);
        System.out.println(match2);



    }
}
