package com.example.tsi.carlos.picon.demo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name="film")
public class Film{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int film_id;

    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int rental_duration;
    private float rental_rate ;
    private float replacement_cost;
    private String rating;
    private String special_features;

    /*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
          joinColumns = {
            @JoinColumn(name="film_id", referencedColumnName = "film_id",
            nullable = false, updatable = false)},
          inverseJoinColumns = {
            @JoinColumn(name="actor_id", referencedColumnName = "actor_id",
                          nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();

     */

    public Film(String title, String description, int release_year,int language_id, int rental_duration,
    float rental_rate,/* int length,*/ float replacement_cost, String rating, String special_features){

        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        //this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;
    }
    /* Setter and Getter:  for ManyToMany*/

    /*public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }
    public Set<Actor> getActor()
    {
        return actor;
    }*/

    public int getFilm_id() {
        return film_id;
    }

        public void setFilm(String title, String description, int release_year,int language_id,
                            int rental_duration, float rental_rate,/* int length,*/ float replacement_cost,
                            String rating, String special_features) {
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.language_id = language_id;
        this.rental_duration = rental_duration;
        this.rental_rate = rental_rate;
        //this.length = length;
        this.replacement_cost = replacement_cost;
        this.rating = rating;
        this.special_features = special_features;

    }

    public String getTitle() { return title;
    }
    public String getDescription() { return description;
    }
    public int getRelease_year() { return release_year;
    }
    public int getLanguage_id() { return language_id;
    }
    public int getRental_duration() { return rental_duration;
    }
    public float getRental_rate() { return rental_rate;
    }
   // public int getLength(){ return length;
   //}
    public float getReplacement_cost() { return replacement_cost;
    }
    public String getRating() { return rating;
    }
    public String getSpecial_features() { return special_features;
    }
    public Film(){

    }
}
