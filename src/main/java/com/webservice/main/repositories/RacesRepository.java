package com.webservice.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webservice.main.models.Race;

@Repository
public interface RacesRepository extends JpaRepository<Race, Long> {

}
