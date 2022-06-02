package com.webservice.main.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webservice.main.models.KingdomBuilding;
import com.webservice.main.models.KingdomBuildingKey;

@Repository
@Transactional
public interface KingdomBuildingRepository extends JpaRepository<KingdomBuilding, KingdomBuildingKey> {
	@Query(value = "SELECT * FROM kingdom_building WHERE kingdom_id = ?1 AND building_id = ?2", nativeQuery = true)
	KingdomBuilding findByKingdomBuildingID(Long kingdomID, Long buildingID);
	
	@Query(value = "SELECT * FROM kingdom_building WHERE kingdom_id = ?1", nativeQuery = true)
	List<KingdomBuilding> findByKingdomID(Long kingdomID);
	
	@Query(value = "SELECT buildings_count FROM kingdom_building WHERE kingdom_id = ?1 AND building_id = ?2", nativeQuery = true)
	int getBuildingCount(Long kingdomID, Long buildingID);
	
	@Modifying
	@Query(value = "UPDATE kingdom_building SET time_to_complete_all = ?3 WHERE kingdom_id = ?1 AND building_id = ?2", nativeQuery = true)
	int setBuildingTimesAll(Long kingdomID, Long buildingID, int timeToSet);

	@Modifying
	@Query(value = "UPDATE kingdom_building SET buildings_count = ?3 WHERE kingdom_id = ?1 AND building_id = ?2", nativeQuery = true)
	int setNumOfBuilding(Long kingdomID, Long buildingID, int newBuildingCount);
}
