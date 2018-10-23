package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepoImpl implements MovieRepoInt{



    @Autowired
    JdbcTemplate template;

    private List<MovieImpl> movies = new ArrayList<>();
    private List<MovieImpl> searched = new ArrayList<>();


    @Override
    public List<MovieImpl> getMovies() throws SQLException {
        return null;
    }

    @Override
    public List<MovieImpl> getSearched() {
        return null;
    }

    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        return null;
    }

    @Override
    public void updateMovie(MovieImpl movie) {

    }

    @Override
    public void deleteMovie(int id) {

    }

    @Override
    public MovieImpl selectMovie(int id) {
        return null;
    }

    @Override
    public List<MovieImpl> searchMovie(String search) {
        return null;
    }

    @Override
    public List<MovieImpl> searchMovie(int id) {
        return null;
    }
}
