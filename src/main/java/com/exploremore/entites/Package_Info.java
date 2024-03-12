package com.exploremore.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.aot.generate.GeneratedTypeReference;

@Entity
public class Package_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private int day ;



}
