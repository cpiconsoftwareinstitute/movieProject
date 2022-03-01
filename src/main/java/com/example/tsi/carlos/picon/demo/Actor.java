package com.example.tsi.carlos.picon.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="actor")
public class Actor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actor_id;

    private String first_name;
    private String last_name;

    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Film> film = new HashSet<>();



    public Actor(String first_name,String last_name){

        this.first_name = first_name;
        this.last_name = last_name;

    }

    public int getActor_id() {
        return actor_id;
    }

    //needed to Many-to-Many mapping
    public Set<Film> getFilm() {
        return film;
    }
    public void setFilm(Set<Film> films) {
        this.film = films;
    }
    /* Setter and Getter:  first name*/

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getFirst_name() {

        return first_name;
    }



    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getLast_name() {

        return last_name;
    }
    public Actor(){

    }
}
