package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class ActorImpl implements ActorInt {

    private String name;
    private int id;

    public ActorImpl(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public ActorImpl() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

}
