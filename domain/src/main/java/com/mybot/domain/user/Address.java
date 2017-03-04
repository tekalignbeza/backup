package com.mybot.domain.user;

import com.mybot.domain.base.CoreEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tekalign.bezawork on 12/28/16.
 */

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends CoreEntity{
 
    String id;
    String street1;
    String street2;
    String city;
    String state;
    String zip;
    String country;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", country=" + country + '}';
    }
    
     
}
