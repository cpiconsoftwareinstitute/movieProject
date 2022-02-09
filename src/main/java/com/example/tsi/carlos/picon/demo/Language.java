package com.example.tsi.carlos.picon.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.persistence.Entity;

@Entity
public class Language{

    @Id
    @GeneratedValue(strategy = GenerationType.Table)
    private int language_id;

    private String name;

    public Language(String name){

        this.name = name;

    }

    public int getLanguage_id() {
        return language_id;
    }

    public String getName() {
        return name;
    }

    public Language(){

    }
}
