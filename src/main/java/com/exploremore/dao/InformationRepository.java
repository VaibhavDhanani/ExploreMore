package com.exploremore.dao;

import com.exploremore.entites.Package_Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Package_Info, Long> {

}
