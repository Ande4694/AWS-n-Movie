package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ActorInt {

   String getName();
   void setName(String name);
   List<MovieImpl> getMoviesIn();
   int getId();


}
