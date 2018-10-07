package com.quicksilver.moviesapp.repositories.base;

import com.quicksilver.moviesapp.models.User;

import java.io.IOException;

public interface UserRepository {
    User login(User item) throws IOException;

    User register(User item) throws IOException;
}
