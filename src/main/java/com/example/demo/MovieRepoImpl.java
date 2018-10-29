package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
;

@Repository
public class MovieRepoImpl implements MovieRepoInt{

/*    @Autowired
    MovieImpl movie;
    JdbcTemplate template;
    private List<MovieImpl> movies = new ArrayList<>();
    private List<MovieImpl> searched = new ArrayList<>();

    public MovieRepoImpl(int id, String title, String genre, String year) {
    }*/


    @Override
    public List<MovieImpl> getMovies() /*throws SQLException*/ {

        String sql = "SELECT * FROM movies;";

        return this.template.query(sql, new ResultSetExtractor<List<MovieImpl>>() {
            @Override
            public List<MovieImpl> extractData(ResultSet rs) throws SQLException, DataAccessException {
                int id;
                String title, genre, year;
                ArrayList<MovieImpl> movies = new ArrayList<>();

                while (rs.next()) {
                    id = rs.getInt("idMovies");
                    title = rs.getString("title");
                    genre = rs.getString("genre");
                    year = rs.getString("year");

                    movies.add(new MovieImpl(id, title, genre, year));
                }
                return movies;
            }
        });
    }

    @Override
    public List<MovieImpl> getSearched() {
        return null;
    }

    @Autowired
    JdbcTemplate template;





/*    @Override
    public List<MovieImpl> getSearched() {
        return searched;
    }*/

    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        String sql = "INSERT INTO movies VALUES(default, ?, ?, ?);";
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
    public List<MovieImpl> searchMovie(int id) { return null; }

}
