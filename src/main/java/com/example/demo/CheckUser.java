package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CheckUser {
    public boolean isUser(String name, String password){
         boolean userName = name.equalsIgnoreCase("kevin");
         boolean pass     = password.equalsIgnoreCase("123");
         return  userName && pass;
    }
}
