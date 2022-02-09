package com.example.tsi.carlos.picon.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int category_id;

        private String name;

        public Category(String name){

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

        public Category(){

        }
    }

