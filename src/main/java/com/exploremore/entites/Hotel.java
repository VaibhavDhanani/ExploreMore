package com.exploremore.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int h_id;

    private String h_name;

    private double h_price;

    private int availability;

    private double ratings;

    public Hotel(int h_id, String h_name, double h_price, int availability, double ratings) {
        this.h_id = h_id;
        this.h_name = h_name;
        this.h_price = h_price;
        this.availability = availability;
        this.ratings = ratings;
    }

    public Hotel() {
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public double getH_price() {
        return h_price;
    }

    public void setH_price(double h_price) {
        this.h_price = h_price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "h_id=" + h_id +
                ", h_name='" + h_name + '\'' +
                ", h_price=" + h_price +
                ", availability=" + availability +
                ", ratings=" + ratings +
                '}';
    }
}