package com.exploremore.entites;

import jakarta.persistence.*;
import org.springframework.aot.generate.GeneratedTypeReference;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Package_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id")
    private Package pack;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    private int day;
    private String description;

    public Package_Info(Long id, Package pack, Hotel hotel, int day, String description) {
        this.id = id;
        this.pack = pack;
        this.hotel = hotel;
        this.day = day;
        this.description = description;
    }
    public Package_Info() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Package_Info{" +
                "id=" + id +
                ", pack=" + pack +
                ", hotel=" + hotel +
                ", day=" + day +
                ", description='" + description + '\'' +
                '}';
    }

//    public List<Hotel> getHotels(long id) {
//        List<Hotel> result = new ArrayList<Hotel>();
//        for()
//        return result;
//    }
}
