package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface MovieRepoInt {

    List<MovieImpl> getMovies() throws SQLException;
    List<MovieImpl> getSearched();
    MovieImpl createMovie(MovieImpl movie);
    void updateMovie(MovieImpl movie);
    void deleteMovie(int id);
    MovieImpl selectMovie(int id);
    List<MovieImpl> searchMovie(String search);
    List<MovieImpl> searchMovie(int id);

}
