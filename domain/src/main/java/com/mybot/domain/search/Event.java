/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mybot.domain.search;

/**
 *
 * @author teke
 */
public class Event {

    String title;
    String date;
    String distance;
    String description;
    String price;
    String place;
    String category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", distance='" + distance + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", place='" + place + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    public void printme(){
        System.out.println("Hello ");
    }
}
