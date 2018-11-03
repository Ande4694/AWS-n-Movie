package com.example.demo.Repo;

import com.example.demo.Model.ActorImpl;
import com.example.demo.Model.MovieImpl;
import com.example.demo.Controller.MovieController;
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
import java.util.logging.Logger;
;

@Repository
public class MovieRepoImpl implements MovieRepoInt {


    @Autowired
    JdbcTemplate template;

    @Override
    public List<MovieImpl> getMovies() {

        String sql = "SELECT * FROM movie.movies";

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

    public List<ActorImpl> getAllActors() {

        String sql = "SELECT * FROM movie.actors";

        return this.template.query(sql, new ResultSetExtractor<List<ActorImpl>>() {
            @Override
            public List<ActorImpl> extractData(ResultSet rs) throws SQLException, DataAccessException {
                int id;
                String name;
                ArrayList<ActorImpl> actors = new ArrayList<>();

                while (rs.next()) {
                    id = rs.getInt("idactors");
                    name = rs.getString("name");


                    actors.add(new ActorImpl(name, id));
                }
                return actors;
            }
        });
    }


    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        String sql = "INSERT INTO movie.movies VALUES(default, ?, ?, ?);";
        this.template.update(sql, movie.getTitle(), movie.getGenre(), movie.getYear());

        return movie;
    }

    public void createRelation(int actorId, int movieId){

        String sql ="insert into movie.actormovie values (default,?,? )";

        this.template.update(sql, actorId, movieId);

    }

    public ActorImpl createActor(ActorImpl actor) {
        String sql = "INSERT INTO movie.actors VALUES (default, ?)";
        this.template.update(sql, actor.getName());

        return actor;
    }

    @Override
    public void updateMovie(MovieImpl movie, int id) {


        String sql = "UPDATE movie.movies " +
                "SET title=?, genre=?, year=?" +
                "WHERE idmovies ="+id;

        this.template.update(sql, movie.getTitle(), movie.getGenre(), movie.getYear());



    }

    public void safeDelete(int id){

        //check movie for om den har actors i sig
        //kan gøre med "getActorsIn"
        // få id fra "actormovie"
        //delete from actormovie where actors = 1?

        // alternativt, lav remove relation

    }

    public List<ActorImpl> getActorsIn(int movieId)throws SQLException{

        String sql = "SELECT name, idactors FROM movie.actormovie " +
                "inner join actors on movie.actormovie.actors=actors.idactors " +
                "WHERE movies="+movieId;

        RowMapper<ActorImpl> rm = new BeanPropertyRowMapper<>(ActorImpl.class);
        List<ActorImpl> actorsIn = template.query(sql, rm);

        return actorsIn;


    }


    @Override
    public void deleteMovie(int id) {

        String sql ="DELETE FROM movie.movies WHERE idmovies=?;";
        this.template.update(sql, id);
    }

    public void deleteActor(int id){

        String sql = "DELETE FROM movie.actors WHERE idactors=?";
        this.template.update(sql, id);
    }

    @Override
    public MovieImpl selectMovie(int id) {
        String sql="SELECT * FROM movie.movies WHERE idmovies=?";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);
        MovieImpl movie = template.queryForObject(sql, rm, id);
        return movie;

    }

    @Override
    public List<MovieImpl> searchMovieTitle(String search) {

        String sql="SELECT * FROM movie.movies WHERE title LIKE ?";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);

        List<MovieImpl> searched = template.query(sql, rm, search);
        return searched;
    }

    public List<MovieImpl> searchMovieGenre(String search){

        String sql ="SELECT * FROM movie.movies WHERE genre LIKE ?";

        RowMapper<MovieImpl> rm = new BeanPropertyRowMapper<>(MovieImpl.class);

        List<MovieImpl> searched = template.query(sql, rm, search);
        return searched;
    }

    public List<ActorImpl> searchActor(String search){

        String sql = "SELECT * FROM movie.actors WHERE name LIKE ?";

        RowMapper<ActorImpl> rm = new BeanPropertyRowMapper<>(ActorImpl.class);

        List<ActorImpl> searched = template.query(sql, rm, search);

        return searched;
    }


}