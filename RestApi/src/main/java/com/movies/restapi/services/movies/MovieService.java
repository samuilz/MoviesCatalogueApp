package com.movies.restapi.services.movies;

import com.movies.restapi.entities.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();

    Movie getById(int id);

    Movie add(Movie movie);

    Movie update(int id, Movie movie);

}
