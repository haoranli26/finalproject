package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    public Movie findMovieByMovieName(String movie);

    @Query(value = "select * from Movie where Movie.id=(select movie_id from user_movies where user_id=:id) ",nativeQuery = true)
    public List<Movie> findMovieByUser(@Param("id") Integer id);

}
