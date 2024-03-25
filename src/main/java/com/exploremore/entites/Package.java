package com.exploremore.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 20)
    private String name;

    @Column(name = "duration", nullable = false, length = 4)
    private int duration;

    @Column(name = "price", nullable = false,length = 10)
    private double price;

    @Column(name = "availability", nullable = false,length=5)
    private int availability;

}
