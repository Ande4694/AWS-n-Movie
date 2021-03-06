package com.example.demo.repo;

import com.example.demo.models.MovieImpl;

import java.sql.SQLException;
import java.util.List;


public interface MovieRepoInt {

    List<MovieImpl> getMovies() throws SQLException;

    MovieImpl createMovie(MovieImpl movie);
    void updateMovie(MovieImpl movie, int id);
    void deleteMovie(int id);
    MovieImpl selectMovie(int id);
    List<MovieImpl> searchMovieTitle(String search);

}
