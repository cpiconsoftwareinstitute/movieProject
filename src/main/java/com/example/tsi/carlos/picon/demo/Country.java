package com.example.tsi.carlos.picon.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Country{

    @Id
    @GeneratedValue
    private int country_id;

    private String country;
    private String last_update;

    public Country(String country, String last_update){

        this.country = country;
        this.last_update = last_update;
    }

    public int getCategory_id() {
        return country_id;
    }

    public void setCountry(String country,String last_update ) {
        this.country = country;
        this.last_update = last_update;
    }

    public String getCountry() { return country;
    }
    public String getLast_update() { return last_update;
    }
    public Country(){

    }
}