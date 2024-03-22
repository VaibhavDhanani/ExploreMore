package com.exploremore.controller;

import com.exploremore.dao.PackageRepository;
import com.exploremore.entites.Package;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageRepository pacRepo;

    @GetMapping("/all")
    public List<Package> allPackage() {
        return pacRepo.findAll();
    }

    @GetMapping("/{id}")
    public Package packageById(@PathVariable int id) {
        Optional<Package> optionalUser = pacRepo.findById(id);
        return optionalUser.orElse(null);
    }

    @PostMapping("/add")
    public Package addPackage(@RequestBody Package pac) {
        return pacRepo.save(pac);
    }

    @PutMapping("/update/{id}")
    public Package updatePackage(@PathVariable int id, @RequestBody Package pac) {
        Optional<Package> optionalUser = pacRepo.findById(id);
        if (optionalUser.isPresent()) {
            Package p = optionalUser.get();
            p.setName(pac.getName());
            p.setDuration(pac.getDuration());
            p.setPrice(pac.getPrice());
            p.setAvailability(pac.getAvailability());
            return pacRepo.save(p);
        } else {
            return null;
        }
    }


    @DeleteMapping("/delete/{id}")
    public void deletePackage(@PathVariable int id) {
        pacRepo.deleteById(id);
    }
}
