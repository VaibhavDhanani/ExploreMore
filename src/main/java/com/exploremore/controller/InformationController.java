package com.exploremore.controller;

import com.exploremore.dao.HotelRepository;
import com.exploremore.dao.InformationRepository;
import com.exploremore.entites.Hotel;
import com.exploremore.entites.Package;
import com.exploremore.entites.PackageInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public List<PackageInformation> all()
    {
        return infoRepo.findAll();
    }

    @GetMapping("/package/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public List<PackageInformation> package_by_id(@PathVariable long id)
    {
        List<PackageInformation> list = infoRepo.findAll();
        List<PackageInformation> packages = new ArrayList<>();
        for(PackageInformation info : list) {
            if(info.getPack().getId() == id) {
                packages.add(info);
            }
        }
        return packages;
    }

    @GetMapping("/package/{id}/hotels")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public List<Hotel> hotelsByPackageId(@PathVariable long id) {
        List<PackageInformation> list = infoRepo.findAll();
        List<Hotel> hotels = new ArrayList<>();
        for(PackageInformation info : list) {
            if(info.getPack().getId() == id) {
                hotels.add(info.getHotel());
            }
        }
        return hotels;
    }

    @GetMapping("/hotel/{id}/packages")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public List<Package> packagesByHotelId(@PathVariable long id) {
        List<PackageInformation> list = infoRepo.findAll();
        List<Package> packages = new ArrayList<>();
        for(PackageInformation info : list) {
            if(info.getHotel().getId() == id) {
                packages.add(info.getPack());
            }
        }
        return packages;
    }
}
