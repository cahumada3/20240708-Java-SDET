package com.skillstorm.demo.services;

import java.util.Optional;

import com.skillstorm.demo.models.Movie;
import com.skillstorm.demo.repositories.MovieRepository;

public class MovieService {

    private MovieRepository repo;

    // use dependency injection to get an instance of the MovieRepository
    public MovieService(MovieRepository repo) {
        this.repo = repo;
    }

    public Iterable<Movie> findAll() {
        return repo.findAll();
    }

    public Optional<Movie> findById(int id) {
        return repo.findById(id);
    }


}
