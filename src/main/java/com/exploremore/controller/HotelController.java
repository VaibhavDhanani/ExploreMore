package com.exploremore.controller;

import com.exploremore.dao.HotelRepository;
import com.exploremore.entites.Hotel;
import com.exploremore.exception.NoElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelrepo;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('USER','MANAGER','ADMIN')")
    public List<Hotel> hotels() {
        return hotelrepo.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public Hotel hotelById(@PathVariable int id) {
        if(hotelrepo.findById(id).isEmpty()) {
            throw new NoElementFoundException("No Such Hotel Found");
        }
        Optional<Hotel> optionalUser = hotelrepo.findById(id);
        return optionalUser.orElse(null);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public Hotel addHotel(@RequestBody Hotel hotel, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("Authenticated User: " + userDetails.getUsername());
        return hotelrepo.save(hotel);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public Hotel updateHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        if(hotelrepo.findById(id).isEmpty()) {
            throw new NoElementFoundException("No Such Hotel Found");
        }
        return hotelrepo.save(hotel);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public void deleteHotel(@PathVariable int id) {
        if(hotelrepo.findById(id).isEmpty()) {
            throw new NoElementFoundException("No Such Hotel Found");
        }
        hotelrepo.deleteById(id);
    }
}
