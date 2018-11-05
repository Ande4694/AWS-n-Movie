package com.example.demo;

public class MovieImpl  {


    private int id;
    private String title;
    private String year;
    private String genre;

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

}
