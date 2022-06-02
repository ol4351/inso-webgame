package com.webservice.main.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.main.views.BuildingView;

@Repository
@Transactional
public interface BuildingViewRepository extends JpaRepository<BuildingView, Long> {
	
	@Query(value = "SELECT * FROM buildingsview WHERE kingdom_id = ?1", nativeQuery = true)
	List<BuildingView> findByKingdomID(Long kingdomID);
}
