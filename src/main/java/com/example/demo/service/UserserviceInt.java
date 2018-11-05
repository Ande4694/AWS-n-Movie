package com.example.demo.service;

import com.example.demo.models.MovieImpl;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public interface UserserviceInt {

    List<MovieImpl> getMovies() throws SQLException /*throws SQLException*/;
    List<MovieImpl> getSearchedByTitle(String search);
    MovieImpl createMovie(MovieImpl movie) /*throws  SQLException*/;
    void updateMovie(MovieImpl movie, int id);
    void deleteMovie(int id);
    MovieImpl selectMovie(int id);


}
