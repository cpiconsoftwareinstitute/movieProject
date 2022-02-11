package com.example.tsi.carlos.picon.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idreview;
    private int film_film_id;

    private String reviewcol;

    public Review(String reviewcol,int film_film_id ){

        this.reviewcol = reviewcol;
        this.film_film_id = film_film_id;

    }

    public int getIdreview() {
        return idreview;
    }

    public void setReviewcol(String reviewcol) {

        this.reviewcol = reviewcol;
    }
    public void setFilm_film_id(int film_film_id) {

        this.film_film_id = film_film_id;
    }
    public int getFilm_film_id() {

        return film_film_id;
    }
    public String getReviewcol() {

        return reviewcol;
    }

    public Review(){

    }


}
