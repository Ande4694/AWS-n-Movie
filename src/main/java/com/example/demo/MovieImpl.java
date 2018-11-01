package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class MovieImpl  {


    private int id;
    private String title;
    private String year;
    private String genre;
    private List<ActorImpl> actorsIn = new ArrayList<>();


    @Override
    public String toString() {
        return "MovieImpl{" +
                ", id=" + id +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +

                '}';
    }

    public MovieImpl() {
    }

    public MovieImpl(int id, String title, String genre, String year) {
        this.id = id;
        this.year = title;
        this.genre = genre;
        this.title = year;
    }




    public int getId() { return id; }


    public String getTitle() {
        return title;
    }


    public String getGenre() {
        return genre;
    }


    public String getYear() {
        return year;
    }


    public void setId(int id){
        this.id = id;
    }


    public void setTitle(String title) {this.title = title; }



    public void setGenre(String genre) {this.genre = genre; }


    public void setYear(String year) {this.year = year; }


    public List<ActorImpl> getActorsIn() {
        return actorsIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieImpl movie = (MovieImpl) o;
        return id == movie.id &&
                year == movie.year &&
                Objects.equals(title, movie.title) &&
                Objects.equals(genre, movie.genre);

    }


    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, year);
    }
}
