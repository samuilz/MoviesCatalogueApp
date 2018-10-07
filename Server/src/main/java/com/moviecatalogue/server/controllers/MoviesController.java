package com.moviecatalogue.server.controllers;

import com.moviecatalogue.server.models.Movie;
import com.moviecatalogue.server.services.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private BaseService<Movie> service;

    @Autowired
    public MoviesController(BaseService<Movie> service) {
        this.service = service;
    }

    @PostMapping("/new")
    public void addMovie(@RequestBody Movie movie){
        service.add(movie);
    }

    @GetMapping
    public List<Movie> getMovies() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        service.update(id, movie);
    }
}
