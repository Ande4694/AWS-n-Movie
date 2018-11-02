package com.example.demo.Model;

import com.example.demo.Model.ActorImpl;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MovieInt {

    int getId();
    String getTitle();
    String getGenre();
    String getYear();
    void setTitle(String title);
    void setGenre(String genre);
    void setYear(String year);
    List<ActorImpl> getActorsIn();



}
