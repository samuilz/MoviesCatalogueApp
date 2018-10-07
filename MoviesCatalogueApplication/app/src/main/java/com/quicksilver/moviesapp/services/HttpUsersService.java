package com.quicksilver.moviesapp.services;

import com.quicksilver.moviesapp.models.User;
import com.quicksilver.moviesapp.repositories.base.UserRepository;
import com.quicksilver.moviesapp.services.base.UsersService;

import java.io.IOException;

public class HttpUsersService implements UsersService {

    private final UserRepository mUserRepository;

    public HttpUsersService(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    @Override
    public User login(User user) throws IOException {
        return mUserRepository.login(user);
    }

    @Override
    public User register(User user) throws IOException {
        return mUserRepository.register(user);
    }
}
