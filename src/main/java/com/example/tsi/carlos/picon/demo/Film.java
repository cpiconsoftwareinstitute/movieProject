package com.example.tsi.carlos.picon.demo;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "film")
@Entity
public class Film{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int film_id;

    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int rental_duration;
    private int length;
    private String rating;
    private int category_id;
    //Needed to add ManyToOne connection to get language information
    @ManyToOne
    @JoinColumn(name ="language_id", insertable = false, updatable = false)
    private Language language;

    public Film(String title, String description, int release_year, int language_id, int rental_duration,
                 int length, String rating, int category_id){

        this.title = title;
        this.description=description;
        this.release_year=release_year;
        this.language_id = language_id;
        this.rental_duration=rental_duration;
        this.length=length;
        this.rating=rating;
        this.category_id=category_id;

    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "film_actor",
            joinColumns = {
                    @JoinColumn(name = "film_id", referencedColumnName = "film_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id",
                            nullable = false, updatable = false)})
    private Set<Actor> actor = new HashSet<>();

    public Set<Actor> getActor() {

        return actor;
    }

    public void setActor(Set<Actor> actor) {
        this.actor = actor;
    }

    public Film(){

    }

    public int getFilm_id() {
        return film_id;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public String getTitle() {
        return title;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getCategory_id() {
        return category_id;
    }
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setCategory_id(int category_id) {
    }
}