package com.example.tsi.carlos.picon.demo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="film")
public class Film{

    @Id
    @GeneratedValue
    private int film_id;

    private String title;
    private String description;
    private String release_year;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film",
          joinColumns = {
            @JoinColumn(name="film_id", referencedColumnName = "film_id",
            nullable = false, updatable = false)},
          inverseJoinColumns = {
            @JoinColumn(name="actor_id", referencedColumnName = "actor_id",
                          nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();*/


    public Film(String title, String description, String release_year){

        this.title = title;
        this.description = description;
        this.release_year = release_year;
    }

    public int getFilm_id() {
        return film_id;
    }

        public void setFilm(String title, String description, String release_year) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
    }

    public String getTitle() { return title;
    }
    public String getDescription() { return description;
    }
    public String getRelease_year() { return release_year;
    }
    public Film(){

    }
}
