package com.example.demo;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface UserserviceInt {

    List<MovieImpl> getMovies() throws SQLException;
    List<MovieImpl> getSearched();
    MovieImpl createMovie(MovieImpl movie);
    void updateMovie(MovieImpl movie);
    void deleteMovie(int id);
    MovieImpl selectMovie(int id);
    List<MovieImpl> searchMovie(String search);
    List<MovieImpl> searchMovie(int id);
    void clearSearch();

}
