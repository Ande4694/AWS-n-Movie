package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
;

@Repository
public class MovieRepoImpl implements MovieRepoInt{


    @Autowired
    JdbcTemplate template;
    MovieImpl movie;


    private List<MovieImpl> searched = new ArrayList<>();

    @Override
    public List<MovieImpl> getMovies() {

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
    public MovieImpl createMovie(MovieImpl movie) {
        String sql = "INSERT INTO movie.movies VALUES(default, ?, ?, ?);";
        this.template.update(sql, movie.getTitle(), movie.getGenre(), movie.getYear());

        return movie;
    }

    @Override
    public void updateMovie(int id) {

        //POSTMAPPING
        String sql = "UPDATE movie.movies " +
                "SET title=?, genre=?, year=?" +
                "WHERE idMovies ="+id+";";

        this.template.update(sql, movie.getTitle(), movie.getGenre(), movie.getYear());



    }

    public List<MovieImpl> getSearched(){
        return searched;
    }

    @Override
    public void deleteMovie(int id) {

        String sql ="DELETE FROM movie.movies WHERE idmovie=?;";
        this.template.update(sql, id);
    }

    @Override
    public MovieImpl selectMovie(int id) {
        String sql="SELECT * FROM movie WHERE idmovie=?;";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);
        MovieImpl movie = template.queryForObject(sql, rm, id);
        return movie;
    }

    @Override
    public List<MovieImpl> searchMovieTitle(String search) {
        String sql="SELECT * FROM movie.movies WHERE title =?;";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);
        searched = template.query(sql, rm, search);

        return searched;
    }

    @Override
    public List<MovieImpl> searchMovieGenre(String search) {
        String sql="SELECT * FROM movie.movies WHERE genre=?;";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);
        searched = template.query(sql, rm, search);

        return searched;
    }

    @Override
    public List<MovieImpl> searchMovieId(int id) {
        String sql="SELECT * FROM movie.movies WHERE id =?;";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);
        searched = template.query(sql, rm, id);

        return searched;
    }

}
