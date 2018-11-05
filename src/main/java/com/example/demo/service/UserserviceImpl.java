package com.example.demo.service;

import com.example.demo.models.ActorImpl;
import com.example.demo.models.MovieImpl;
import com.example.demo.repo.MovieRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserserviceImpl implements UserserviceInt {

    @Autowired
    MovieRepoImpl movieRepo;


    @Override
    public List<MovieImpl> getMovies(){

        return movieRepo.getMovies();
    }

    @Override
    public List<MovieImpl> getSearchedByTitle(String search) {

        return movieRepo.searchMovieTitle(search);
    }

    public List<ActorImpl> getActors(){

        return movieRepo.getAllActors();
    }

    public void createRelation(int actorId, int movieId){
        movieRepo.createRelation(actorId, movieId);
    }

    public void deleteRelation(int id){
        movieRepo.deleteRelation(id);
    }

    public List<MovieImpl> getSearchedByGenre(String search){

        return movieRepo.searchMovieGenre(search);
    }

    public List<ActorImpl> getSearchedActor(String search){

        return movieRepo.searchActor(search);
    }

    public ActorImpl createActor(ActorImpl actor){

        return movieRepo.createActor(actor);
    }

    @Override
    public MovieImpl createMovie(MovieImpl movie) {
        return movieRepo.createMovie(movie);
    }

    public List<ActorImpl> getActorsIn(int movieId)throws SQLException{
        return movieRepo.getActorsIn(movieId);
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
            movieRepo.deleteRelation(id);
            movieRepo.deleteMovie(id);
    }

    public void deleteActor(int id){
        movieRepo.deleteActorRelation(id);
        movieRepo.deleteActor(id);
    }

    @Override
    public MovieImpl selectMovie(int id) {
        return movieRepo.selectMovie(id);
    }


}
