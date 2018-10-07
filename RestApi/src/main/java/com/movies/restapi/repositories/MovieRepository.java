package com.movies.restapi.repositories;

import com.movies.restapi.entities.Movie;
import com.movies.restapi.entities.MovieRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findAll();

    Movie getById(int id);

    @SuppressWarnings("unchecked")
    Movie save(Movie movie);

    MovieRating save(MovieRating movieRating);
}
