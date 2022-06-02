package com.webservice.main.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.main.models.Kingdom;

@Transactional
@Repository
public interface KingdomRepository extends JpaRepository<Kingdom, Long> {
	@Query(value = "SELECT * FROM kingdoms WHERE id = ?1", nativeQuery = true)
	Kingdom findByKingdomId(Long id);
	
	@Modifying
	@Query(value = "UPDATE kingdoms SET gold_available = ?2, material_available = ?3, food_available = ?4, knowledge_available = ?5, workforce_available = ?6, area_available = ?7 WHERE id = ?1", nativeQuery = true)
	void updateKingdomResources(Long id, int gold, int material, int food, int knowledge, int workforce, int areaAvailable);
	
	@Modifying
	@Query(value = "UPDATE kingdoms SET gold_production = ?2, material_production = ?3, food_production = ?4, knowledge_production = ?5, workforce_production = ?6 WHERE id = ?1", nativeQuery = true)
	void updateKingdomProduction(Long id, int goldProduction, int materialProduction, int foodProduction, int knowledgeProduction, int workforceProduction);
}
