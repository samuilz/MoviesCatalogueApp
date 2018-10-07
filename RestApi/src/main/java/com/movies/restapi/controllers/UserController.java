package com.movies.restapi.controllers;

import com.movies.restapi.entities.User;
import com.movies.restapi.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/login")
    @PreAuthorize("isAnonymous()")
    public User login(@RequestBody User user) {
        return usersService.getUserByUsername(user.getUsername());
    }


    @PostMapping("users/register")
    @PreAuthorize("isAnonymous()")
    public User register(@RequestBody User user) {
        usersService.create(user);

        return usersService.getUserByUsername(user.getUsername());
    }
}
