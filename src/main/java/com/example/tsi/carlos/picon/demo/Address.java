package com.example.tsi.carlos.picon.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address{

    @Id
    @GeneratedValue
    private int address_id;
    private String address;
    private String district;

    public Address(String address, String district){

        this.address = address;
        this.district = district;
    }

    public int getAddress_id_id() {
        return address_id;
    }

    public void setAddress(String A) {
        this.address = address;
        this.district = district;
    }

    public String getAddress() { return address;
    }
    public String getDistrict() { return district;
    }
    public Address(){

    }
}

