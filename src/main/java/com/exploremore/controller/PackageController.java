package com.exploremore.controller;

import com.exploremore.dao.PackageRepository;
import com.exploremore.entites.Package;
import com.exploremore.exception.NoElementFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/package")
public class PackageController {

    @Autowired
    private PackageRepository pacRepo;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('USER','MANAGER','ADMIN')")
    public List<Package> allPackage() {
        return pacRepo.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','MANAGER','ADMIN')")
    public Package packageById(@PathVariable int id) {
        if (pacRepo.findById(id).isEmpty()) {
            throw new NoElementFoundException("No Such Package Found");
        }
        Optional<Package> optionalUser = pacRepo.findById(id);
        return optionalUser.orElse(null);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public Package addPackage(@RequestBody Package pac) {
        return pacRepo.save(pac);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public Package updatePackage(@PathVariable int id, @RequestBody Package pac) {
        if (pacRepo.findById(id).isEmpty()) {
            throw new NoElementFoundException("No Such Package Found");
        }
        return pacRepo.save(pac);
    }


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    public void deletePackage(@PathVariable int id) {
        if (pacRepo.findById(id).isEmpty()) {
            throw new NoElementFoundException("No Such Package Found");
        }
        pacRepo.deleteById(id);
    }
}
