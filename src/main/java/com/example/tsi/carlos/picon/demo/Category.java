package com.example.tsi.carlos.picon.demo;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="category")
public class Category{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int category_id;
        @OneToMany
        @JoinColumn(name ="category_id",insertable = false,updatable = false)
        @JsonIgnore
        private Set<Film> film;
        private String name;

        public Category( String name){

            this.name = name;

        }

        public int getCategory_id() {
            return category_id;
        }

        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public Set<Film>getFilm(){
        return film;
    }
        public void setFilm(Set<Film> film) {
        this.film = film;
    }
        public Category(){

        }
    }

