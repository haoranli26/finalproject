package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;
    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> getMoviesByUser(int id) {
        return movieRepository.findById(id);
    }
}
