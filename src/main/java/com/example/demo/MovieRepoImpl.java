package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepoImpl implements MovieRepoInt{

    @Autowired
    MovieImpl movie;
    JdbcTemplate template;
    private List<MovieImpl> movies = new ArrayList<>();
    private List<MovieImpl> searched = new ArrayList<>();




    @Override
    public List<MovieImpl> getMovies() throws SQLException {

        String sql = "SELECT * FROM movie;";

        Statement stmt = null;

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            int id = rs.getInt("movieid");
            String title = rs.getString("title");
            String production = rs.getString("production");
            String genre = rs.getString("genre");

            movies.add(new MovieImpl(id, title, production, genre));
        }
        rs.close();
        stmt.close();
        return movies;
    }

    @Override
    public List<MovieImpl> getSearched() {
        return searched;
    }

    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        String sql = "INSERT INTO movie.movies VALUES(default, ?, ?, ?);";
        this.template.update(sql, movie.getTitle(), movie.getYear(), movie.getGenre());

        return movie;
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
