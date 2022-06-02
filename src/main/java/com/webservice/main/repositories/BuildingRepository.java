package com.webservice.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.main.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
	
	@Query(value = "SELECT * FROM buildings WHERE id = ?1", nativeQuery = true)
	Building findByBuildingId(Long id);
}
