package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserserviceImpl implements UserserviceInt{

    @Autowired
    MovieRepoImpl movieRepo;


    @Override
    public List<MovieImpl> getMovies() throws SQLException /*throws SQLException */{
        List<MovieImpl> movies = movieRepo.getMovies();
        return movies;
    }

    @Override
    public List<MovieImpl> getSearched(String search) {
        List<MovieImpl> searched = movieRepo.searchMovieTitle(search);
        return searched;
    }

    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        MovieImpl movie_ = movieRepo.createMovie(movie);
        return movie_;
    }

    @Override
        public void updateMovie(int id) {
            movieRepo.updateMovie(id);


    }

    @Override
    public void deleteMovie(int id) {

    }

    @Override
    public MovieImpl selectMovie(int id) {
        return null;
    }

    @Override
    public void searchMovieTitle(String search) {
        movieRepo.searchMovieTitle(search);


    }

    @Override
    public List<MovieImpl> searchMovie(int id) {
        return null;
    }

    @Override
    public void clearSearch() {

    }
}
