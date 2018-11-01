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
    public List<MovieImpl> getSearchedByTitle(String search) {
        List<MovieImpl> searched = movieRepo.searchMovieTitle(search);
        return searched;
    }

    public List<ActorImpl> getActors(){
        List<ActorImpl> allActors = movieRepo.getAllActors();
        return allActors;
    }

    public void createRelation(int actorId, int movieId){
        movieRepo.createRelation(actorId, movieId);
    }

    public List<MovieImpl> getSearchedByGenre(String search){
        List<MovieImpl> searched = movieRepo.searchMovieGenre(search);
        return searched;
    }

    public List<ActorImpl> getSearchedActor(String search){
        List<ActorImpl> searched = movieRepo.searchActor(search);
        return searched;
    }

    public ActorImpl createActor(ActorImpl actor){
        ActorImpl actor_ = movieRepo.createActor(actor);
        return actor_;
    }

    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        MovieImpl movie_ = movieRepo.createMovie(movie);
        return movie_;
    }

    public List<ActorImpl> getActorsIn(){
        return movieRepo.getActorsIn();
    }

    public List<ActorImpl> GetAllActors(){
        return movieRepo.getAllActors();
    }

    @Override
        public void updateMovie(MovieImpl movie, int id) {
            movieRepo.updateMovie(movie, id);


    }

    @Override
    public void deleteMovie(int id) {
            movieRepo.deleteMovie(id);
    }

    public void deleteActor(int id){
        movieRepo.deleteActor(id);
    }

    @Override
    public MovieImpl selectMovie(int id) {
        return movieRepo.selectMovie(id);
    }


}
