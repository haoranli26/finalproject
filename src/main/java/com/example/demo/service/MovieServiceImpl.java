package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;
    @Override
    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> getMoviesByUser(int id) {
        return movieRepository.findMovieByUser(id);
    }



    @Override
    public Movie findMovieByMovieName(String movie) {
        return movieRepository.findMovieByMovieName(movie);
    }
}
