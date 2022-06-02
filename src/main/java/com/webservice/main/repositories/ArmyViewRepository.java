package com.webservice.main.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.main.views.ArmyView;

@Transactional
@Repository
public interface ArmyViewRepository extends JpaRepository<ArmyView, Long> {
	
	@Query(value = "SELECT * FROM armyview WHERE kingdom_id = ?1", nativeQuery = true)
	List<ArmyView> findByKingdomID(Long id);
}
