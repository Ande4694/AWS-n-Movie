package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieImpl implements MovieInt {

    @Autowired
    ActorImpl actor;

    private int id;
    private String year;
    private String genre;
    private String title;
    private List<ActorImpl> actorsIn;

    @Override
    public String toString() {
        return "MovieImpl{" +
                "actor=" + actor +
                ", id=" + id +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                ", actorsIn=" + actorsIn +
                '}';
    }

    public MovieImpl(int id, String year, String genre, String title) {
        this.id = id;
        this.year = year;
        this.genre = genre;
        this.title = title;
    }

    public MovieImpl() {
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getGenre() {
        return null;
    }

    @Override
    public String getYear() {
        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setGenre(String genre) {

    }

    @Override
    public void setYear(String year) {

    }

    @Override
    public List<ActorImpl> getActorsIn() {
        return null;
    }
}
