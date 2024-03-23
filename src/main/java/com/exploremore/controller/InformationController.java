package com.exploremore.controller;

import com.exploremore.dao.HotelRepository;
import com.exploremore.dao.InformationRepository;
import com.exploremore.entites.Hotel;
import com.exploremore.entites.Package;
import com.exploremore.entites.Package_Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/details")
public class InformationController {

    @Autowired
    private InformationRepository infoRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @RequestMapping("/all")
    public List<Package_Info> all()
    {
        return infoRepo.findAll();
    }

    @GetMapping("/package/{id}")
    public List<Package_Info> package_by_id(@PathVariable long id)
    {
        List<Package_Info> list = infoRepo.findAll();
        List<Package_Info> packages = new ArrayList<>();
        for(Package_Info info : list) {
            if(info.getPack().getId() == id) {
                packages.add(info);
            }
        }
        return packages;
    }

    @GetMapping("/package/{id}/hotels")
    public List<Hotel> hotelsByPackageId(@PathVariable long id) {
        List<Package_Info> list = infoRepo.findAll();
        List<Hotel> hotels = new ArrayList<>();
        for(Package_Info info : list) {
            if(info.getPack().getId() == id) {
                hotels.add(info.getHotel());
            }
        }
        return hotels;
    }

    @GetMapping("/hotel/{id}/packges")
    public List<Package> packagesByHotelId(@PathVariable long id) {
        List<Package_Info> list = infoRepo.findAll();
        List<Package> packages = new ArrayList<>();
        for(Package_Info info : list) {
            if(info.getHotel().getId() == id) {
                packages.add(info.getPack());
            }
        }
        return packages;
    }



}
