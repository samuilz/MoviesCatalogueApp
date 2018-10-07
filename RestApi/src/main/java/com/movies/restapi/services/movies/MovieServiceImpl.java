package com.movies.restapi.services.movies;

import com.movies.restapi.entities.Movie;
import com.movies.restapi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getById(int id) {
        return movieRepository.getById(id);
    }

    @Override
    public Movie add(Movie movie) {
        movieRepository.save(movie);
        movieRepository.save(movie.getMovieRating());
        return movieRepository.getById(movie.getId());
    }

    @Override
    public Movie update(int id, Movie movie) {
        movieRepository.getById(id)
                .getMovieRating()
                .setRating(movie.getMovieRating().getRating());
        movieRepository.getById(id)
                .getMovieRating()
                .setVotes(movie.getMovieRating().getVotes());

        movieRepository.save(movieRepository.getById(id));
        return movieRepository.getById(id);
    }
}
