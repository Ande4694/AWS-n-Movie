package com.example.demo;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface UserserviceInt {

    List<MovieImpl> getMovies() throws SQLException;
    List<MovieImpl> getSearched();
    void createMovie(MovieImpl movie) throws  SQLException;
    void updateMovie(MovieImpl movie);
    void deleteMovie(int id);
    MovieImpl selectMovie(int id);
    List<MovieImpl> searchMovie(String search);
    List<MovieImpl> searchMovie(int id);
    void clearSearch();

}
