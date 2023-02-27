package com.example.demo.service;

import com.example.demo.model.Movie;

import java.util.Optional;

public interface MovieService {
    void saveMovie(Movie movie);
    Optional<Movie> getMoviesByUser(int id);


}
