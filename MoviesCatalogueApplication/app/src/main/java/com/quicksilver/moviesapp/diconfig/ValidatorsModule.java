package com.quicksilver.moviesapp.diconfig;

import com.quicksilver.moviesapp.models.Movie;
import com.quicksilver.moviesapp.validators.MovieValidator;
import com.quicksilver.moviesapp.validators.base.Validator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ValidatorsModule {
    @Provides
    @Singleton
    public Validator<Movie> movieValidator() {
        return new MovieValidator();
    }
}
