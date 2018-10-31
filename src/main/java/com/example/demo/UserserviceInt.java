package com.example.demo;

import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface UserserviceInt {

    List<MovieImpl> getMovies() throws SQLException /*throws SQLException*/;
    List<MovieImpl> getSearched(String search);
    MovieImpl createMovie(MovieImpl movie) /*throws  SQLException*/;
    void updateMovie(int id);
    void deleteMovie(int id);
    MovieImpl selectMovie(int id);
    void searchMovieTitle(String search);
    List<MovieImpl> searchMovie(int id);
    void clearSearch();

}
