package com.example.demo.service;

import com.example.demo.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    void saveMovie(Movie movie);
    List<Movie> getMoviesByUser(int id);
    Movie findMovieByMovieName(String movie);


}
