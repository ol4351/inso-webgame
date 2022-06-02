package com.webservice.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.main.views.StatusView;

@Repository
public interface StatusViewRepository extends JpaRepository<StatusView, Long>  {
	
	@Query(value = "SELECT * FROM statusview WHERE id = ?1", nativeQuery = true)
	StatusView findByKingdomID(Long kingdomID);
}
