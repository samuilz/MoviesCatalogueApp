package com.quicksilver.moviesapp.services.base;

import com.quicksilver.moviesapp.models.Movie;

import java.io.IOException;
import java.util.List;

public interface MoviesService {
    List<Movie> getAllMovies() throws IOException;

    Movie getDetailById(int id) throws IOException;

    List<Movie> getFilteredMovies(String pattern) throws IOException;

    Movie createMovie(Movie movie) throws IOException;

    List<Movie> getLatestMovies() throws IOException;

    Movie updateMovie(int id, Movie movie) throws IOException;
}
