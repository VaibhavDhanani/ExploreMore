package com.exploremore.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Package_Information")
public class PackageInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id")
    private Package pack;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @Column(name = "day", nullable = false,length = 2)
    private int day;

    @Column(name = "description", length = 255)
    private String description;
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
}
