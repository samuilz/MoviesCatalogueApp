package com.quicksilver.moviesapp.services.base;

import com.quicksilver.moviesapp.models.User;

import java.io.IOException;

public interface UsersService {
    User login(User user) throws IOException;

    User register(User user) throws IOException;
}
