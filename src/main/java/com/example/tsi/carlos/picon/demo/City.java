package com.example.tsi.carlos.picon.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class City{

    @Id
    @GeneratedValue
    private int city_id;

    private String city;

    public City(String city){

        this.city = city;

    }

    public int getCategory_id() {
        return city_id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() { return city;
    }
    public City(){

    }
}
