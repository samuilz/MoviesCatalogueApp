package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.http.HttpRequester;
import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.models.User;
import com.quicksilver.moviesapp.parsers.base.JsonParser;
import com.quicksilver.moviesapp.repositories.HttpRepository;
import com.quicksilver.moviesapp.repositories.HttpUsersRepository;
import com.quicksilver.moviesapp.repositories.base.Repository;
import com.quicksilver.moviesapp.repositories.base.UserRepository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Movie> movieRepository(HttpRequester httpRequester, JsonParser<Movie> jsonParser, @Named("serverUrl") String serverUrl) {
        return new HttpRepository<>(httpRequester, jsonParser, serverUrl);
    }

    @Provides
    @Singleton
    public UserRepository userRepository(HttpRequester httpRequester, JsonParser<User> jsonParser, @Named("serverUrl") String serverUrl) {
        return new HttpUsersRepository(httpRequester, jsonParser, serverUrl);
    }
}
