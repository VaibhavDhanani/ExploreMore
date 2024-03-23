package com.exploremore.controller;

import com.exploremore.dao.HotelRepository;
import com.exploremore.entites.Hotel;
import com.exploremore.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelrepo;

    @GetMapping("/all")
    public List<Hotel> hotels() {
        return hotelrepo.findAll();
    }

    @GetMapping("/{id}")
    public Hotel hotelById(@PathVariable int id) {
        if(hotelrepo.findById(id).isEmpty()) {
            throw new BadRequestException("No Such Hotel Found");
        }
        Optional<Hotel> optionalUser = hotelrepo.findById(id);
        return optionalUser.orElse(null);
    }

    @PostMapping("/add")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelrepo.save(hotel);
    }

    @PutMapping("/update/{id}")
    public Hotel updateHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        if(hotelrepo.findById(id).isEmpty()) {
            throw new BadRequestException("No Such Hotel Found");
        }
        return hotelrepo.save(hotel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHotel(@PathVariable int id) {
        if(hotelrepo.findById(id).isEmpty()) {
            throw new BadRequestException("No Such Hotel Found");
        }
        hotelrepo.deleteById(id);
    }
}
