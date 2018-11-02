package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class ActorImpl implements ActorInt {

    private String name;
    private int id;

    @Override
    public String toString() {
        return "ActorImpl{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

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

    public void setId(int id){
        this.id = id;
    }
}
