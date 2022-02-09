package com.example.tsi.carlos.picon.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="actor")
public class Actor{

    @Id
    @GeneratedValue
    private int actor_id;

    private String first_name;
    private String last_name;

    /*@ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    @JsonIgnore // to stop files from infinity ignoring
    private Set<Film> film = new HashSet<>();*/



    public Actor(String first_name,String last_name){

        this.first_name = first_name;
        this.last_name = last_name;

    }

    public int getActor_id() {
        return actor_id;
    }

    /* Setter and Getter:  for ManyToMany*/

    /*public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }
    public Set<Actor> getActor() {

        return actor;
    }*/


    /* Setter and Getter:  first name*/

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {

        return first_name;
    }

    /* Setter and Getter:  last name*/

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getLast_name() {

        return last_name;
    }
    public Actor(){

    }
}
