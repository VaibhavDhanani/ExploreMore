package com.exploremore.dao;

import com.exploremore.entites.PackageInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<PackageInformation, Long> {

}
