package com.umanizales.bikeraces.controller;

import com.umanizales.bikeraces.model.User;
import com.umanizales.bikeraces.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "users")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping
    public List<User> getUserService() {
        return userService.getUsuarios();
    }
}