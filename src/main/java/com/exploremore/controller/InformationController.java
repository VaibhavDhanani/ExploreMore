package com.exploremore.controller;

import com.exploremore.dao.HotelRepository;
import com.exploremore.dao.InformationRepository;
import com.exploremore.dao.PackageRepository;
import com.exploremore.entites.Hotel;
import com.exploremore.entites.Package;
import com.exploremore.entites.PackageInformation;
import com.exploremore.exception.NoElementFoundException;
import org.hibernate.annotations.ParamDef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/details")
public class InformationController {

    @Autowired
    private InformationRepository infoRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    private PackageRepository pacRepo;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public List<PackageInformation> all()
    {
        return infoRepo.findAll();
    }

    @GetMapping("/{id}")
    public PackageInformation getByID(@PathVariable Long id)
    {
        if(infoRepo.findById(id).isEmpty())
        {
            throw new NoElementFoundException("No Such Package Found");
        }
        Optional<PackageInformation> optionalUser = infoRepo.findById(id);
        return optionalUser.orElse(null);
    }

    @GetMapping("/package/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','USER','ADMIN')")
    public List<PackageInformation> package_by_id(@PathVariable long id)
    {
        if(pacRepo.findById((int) id).isEmpty())
        {
            throw new NoElementFoundException("No Such Package Found");
        }
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
        if(pacRepo.findById((int) id).isEmpty())
        {
            throw new NoElementFoundException("No Such Package Found");
        }
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
        if(hotelRepo.findById((int) id).isEmpty())
        {
            throw new NoElementFoundException("No Such Hotel Found");
        }
        List<PackageInformation> list = infoRepo.findAll();
        List<Package> packages = new ArrayList<>();
        for(PackageInformation info : list) {
            if(info.getHotel().getId() == id) {
                packages.add(info.getPack());
            }
        }
        return packages;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public void add(@RequestBody PackageInformation info)
    {
        infoRepo.save(info);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public void update(@PathVariable long id, @RequestBody PackageInformation info)
    {
        if(infoRepo.findById(id).isEmpty())
        {
            throw new NoElementFoundException("No Such Package Found");
        }
        infoRepo.save(info);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
    public void delete(@PathVariable long id)
    {
        if(infoRepo.findById(id).isEmpty())
        {
            throw new NoElementFoundException("No Such Package Found");
        }
        infoRepo.deleteById(id);
    }

}
