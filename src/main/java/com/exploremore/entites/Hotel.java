package com.exploremore.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 25,nullable = false,name = "name")
    private String name;
    @Column(length = 7,nullable = false,name = "price")
    private double price;

    @Column(length = 4,nullable = false,name = "availability")
    private int availability;

    @Column(length = 4,nullable = false,name = "ratings")
    private double ratings;
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                ", ratings=" + ratings +
                '}';
    }
}