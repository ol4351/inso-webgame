package com.webservice.main.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.main.models.Building;
import com.webservice.main.models.Kingdom;
import com.webservice.main.models.KingdomBuilding;
import com.webservice.main.repositories.ArmyViewRepository;
import com.webservice.main.repositories.BuildingRepository;
import com.webservice.main.repositories.BuildingViewRepository;
import com.webservice.main.repositories.KingdomBuildingRepository;
import com.webservice.main.repositories.KingdomRepository;
import com.webservice.main.repositories.StatusViewRepository;
import com.webservice.main.views.ArmyView;
import com.webservice.main.views.BuildingView;
import com.webservice.main.views.StatusView;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@EnableScheduling
@RequestMapping("/api/main")
public class MainController {
	public static final int FAST_MULTIPLIER = 3;
	public static final int DEMOLISH_RETURN_PERCENT = 60;
	
	@Autowired
	private BuildingViewRepository buildingViewRepository;
	@Autowired
	private StatusViewRepository statusViewRepository;
	@Autowired
	private ArmyViewRepository armyViewRepository;
	@Autowired 
	private KingdomBuildingRepository kingdomBuildingRepository;
	@Autowired
	private BuildingRepository buildingRepository;
	@Autowired
	private KingdomRepository kingdomRepository;
	
	@GetMapping("/status")
	public @ResponseBody Object getStatus(@RequestParam String id) {
		//TODO check params validity
		StatusView kingdom = statusViewRepository.findByKingdomID(Long.decode(id));
		List<Building> buildings = buildingRepository.findAll();
		List<KingdomBuilding> kingdomBuilding = kingdomBuildingRepository.findByKingdomID(Long.decode(id));
		int totalGoldStorage = 0;
		int totalMaterialStorage = 0;
		int totalFoodStorage = 0;
		int totalKnowledgeStorage = 0;
		int totalWorkforceStorage = 0;
		
		for (int i = 0; i < buildings.size(); i++) {
			totalGoldStorage += buildings.get(i).getGoldStorage() * kingdomBuilding.get(i).getBuildingsCount();
			totalMaterialStorage += buildings.get(i).getMaterialStorage() * kingdomBuilding.get(i).getBuildingsCount();
			totalFoodStorage += buildings.get(i).getFoodStorage() * kingdomBuilding.get(i).getBuildingsCount();
			totalKnowledgeStorage += buildings.get(i).getKnowledgeStorage() * kingdomBuilding.get(i).getBuildingsCount();
			totalWorkforceStorage += buildings.get(i).getWorkforceStorage() * kingdomBuilding.get(i).getBuildingsCount();
		}
		kingdom.setGoldStorage(totalGoldStorage);
		kingdom.setMaterialStorage(totalMaterialStorage);
		kingdom.setFoodStorage(totalFoodStorage);
		kingdom.setKnowledgeStorage(totalKnowledgeStorage);
		kingdom.setWorkforceStorage(totalWorkforceStorage);
		System.out.println("Status data loaded and sent to " + id);;
		return kingdom;
	}
	
	@GetMapping("/buildings")
	public @ResponseBody Object[] getBuildings(@RequestParam String id) {
		//TODO check params validity
		ArrayList<BuildingView> buildings = new ArrayList<BuildingView>(buildingViewRepository.findByKingdomID(Long.decode(id)));
		System.out.println("Buildings data loaded and sent to " + id);
		return buildings.toArray(new BuildingView[0]);
	}
	
	@PostMapping("/build")
	public @ResponseBody String getBuildingsToBuild(@RequestParam String id, @RequestParam boolean fast, @RequestBody Map<Integer, Integer> buildingsToBuild) {
		//TODO check params validity
		ArrayList<BuildingView> buildings = new ArrayList<BuildingView>(buildingViewRepository.findByKingdomID(Long.decode(id)));
		Kingdom kingdom = kingdomRepository.findByKingdomId(Long.decode(id));
		System.out.println("Buildings build data loaded from " + kingdom.getName());
		int totalGoldCost = 0;
		int totalMaterialCost = 0;
		int totalWorkforceCost = 0;
		int totalAreaCost = 0;
		BuildingView building;
		List<Integer> newTotalBuildtimes = new ArrayList<Integer>();
		
		// calculate total cost of ordered buildings
		for (Integer key: buildingsToBuild.keySet()) {
			int val = buildingsToBuild.get(key);
			building = buildings.get(key-1);
			int newTotalBuildTime = 0;
			if (val != 0) {
				if (!fast)
					newTotalBuildTime = val * (building.getBuildTime()) + building.getTimeToCompleteAll();
				totalGoldCost += building.getGoldCost() * val;
				totalMaterialCost += building.getMaterialCost() * val;
				totalWorkforceCost += building.getWorkforceUpkeep() * val;
				totalAreaCost += building.getAreaUpkeep() * val;
			}
			else {
				int timeRemainingForNext = building.getTimeToCompleteAll() % building.getBuildTime();
				int returnPercent = timeRemainingForNext * 100 / building.getBuildTime();
				newTotalBuildTime = 0;
				totalGoldCost -= building.getTimeToCompleteAll() / building.getBuildTime() * building.getGoldCost() + building.getGoldCost() * returnPercent / 100;
				totalMaterialCost -= building.getTimeToCompleteAll() / building.getBuildTime() * building.getMaterialCost() + building.getMaterialCost() * returnPercent / 100;
				totalWorkforceCost -= building.getTimeToCompleteAll() / building.getBuildTime() * building.getWorkforceUpkeep();
				totalAreaCost -= building.getTimeToCompleteAll() / building.getBuildTime() * building.getAreaUpkeep();
				if (timeRemainingForNext != 0) {
					totalWorkforceCost -= building.getWorkforceUpkeep();
					totalAreaCost -= building.getAreaUpkeep();
				}
			}
			newTotalBuildtimes.add(newTotalBuildTime);
		}
		
		// checks if calculated costs of ordered buildings are available
		if (!fast) {
			if (totalGoldCost > kingdom.getGoldAvailable())
				return "Not enough gold.";
			if (totalMaterialCost > kingdom.getMaterialAvailable())
				return "Not enough material.";
		} 
		else {
			if (FAST_MULTIPLIER * totalGoldCost > kingdom.getGoldAvailable())
				return "Not enough gold.";
			if (FAST_MULTIPLIER * totalMaterialCost > kingdom.getMaterialAvailable())
				return "Not enough material.";
		}
		if (totalWorkforceCost > kingdom.getWorkforceAvailable())
			return "Not enough free workers.";
		if (totalAreaCost > kingdom.getAreaAvailable())
			return "Not enough free space.";
		
		// if there are enough resources for all buildings, we can proceed to update all build times for new buildings (or build them immediately)
		int i = 0;
		for (Integer key: buildingsToBuild.keySet()) {
			Long keyLong = key.longValue();
			System.out.println("Building " + keyLong + " - " + newTotalBuildtimes.get(i) + " turn(s)");
			if (!fast)
				kingdomBuildingRepository.setBuildingTimesAll(Long.decode(id), keyLong, newTotalBuildtimes.get(i));
			else
				kingdomBuildingRepository.setNumOfBuilding(Long.decode(id), keyLong, kingdomBuildingRepository.getBuildingCount(Long.decode(id), keyLong) + buildingsToBuild.get(key));
			i++;
			
		}
		
		// set kingdom resources based on calculated resources needed for ordered buildings
		if (!fast) {
			kingdomRepository.updateKingdomResources(Long.decode(id),
					kingdom.getGoldAvailable() - totalGoldCost,
					kingdom.getMaterialAvailable() - totalMaterialCost,
					kingdom.getFoodAvailable(),
					kingdom.getKnowledgeAvailable(),
					kingdom.getWorkforceAvailable() - totalWorkforceCost,
					kingdom.getAreaAvailable() - totalAreaCost);
		} 
		else {
			kingdomRepository.updateKingdomResources(Long.decode(id),
					kingdom.getGoldAvailable() - FAST_MULTIPLIER * totalGoldCost,
					kingdom.getMaterialAvailable() - FAST_MULTIPLIER * totalMaterialCost,
					kingdom.getFoodAvailable(),
					kingdom.getKnowledgeAvailable(),
					kingdom.getWorkforceAvailable() - totalWorkforceCost,
					kingdom.getAreaAvailable() - totalAreaCost);
		}
	
		return "processed";
	}
	
	@PostMapping("/destroy")
	public @ResponseBody String getBuildingsToDestroy(@RequestParam String id, @RequestBody Map<Integer, Integer> buildingsToDestroy) {
		//TODO check params validity
		List<Building> buildings = new ArrayList<Building>(buildingRepository.findAll());
		Kingdom kingdom = kingdomRepository.findByKingdomId(Long.decode(id));
		System.out.println("Buildings destroy data loaded from " + kingdom.getName());
		int totalGoldRefund = 0;
		int totalMaterialRefund = 0;
		int totalWorkforceRefund = 0;
		int totalAreaRefund = 0;
		
		List<Integer> newBuildingsCount = new ArrayList<Integer>(); 
		for (Integer key: buildingsToDestroy.keySet()) {
			Long keyLong = key.longValue();
			if (kingdomBuildingRepository.getBuildingCount(Long.decode(id), keyLong) >= buildingsToDestroy.get(key) && buildingsToDestroy.get(key) >= 0)
				newBuildingsCount.add(buildingsToDestroy.get(key));
			totalGoldRefund += buildingsToDestroy.get(key) * buildings.get(key-1).getGoldCost();
			totalMaterialRefund += buildingsToDestroy.get(key) * buildings.get(key-1).getMaterialCost();
			totalWorkforceRefund += buildingsToDestroy.get(key) * buildings.get(key-1).getWorkforceUpkeep();
			totalAreaRefund += buildingsToDestroy.get(key) * buildings.get(key-1).getAreaUpkeep();
		}
		if (newBuildingsCount.size() != buildingsToDestroy.size())
			return "Wrong number of buildings to destroy: " + newBuildingsCount.size() + " " + buildingsToDestroy.size();
		for (Integer key: buildingsToDestroy.keySet()) {
			Long keyLong = key.longValue();
			kingdomBuildingRepository.setNumOfBuilding(Long.decode(id), keyLong, kingdomBuildingRepository.getBuildingCount(Long.decode(id), keyLong) - buildingsToDestroy.get(key));
		}
		kingdomRepository.updateKingdomResources(Long.decode(id),
				kingdom.getGoldAvailable() + DEMOLISH_RETURN_PERCENT * totalGoldRefund / 100,
				kingdom.getMaterialAvailable() + DEMOLISH_RETURN_PERCENT * totalMaterialRefund / 100,
				kingdom.getFoodAvailable(),
				kingdom.getKnowledgeAvailable(),
				kingdom.getWorkforceAvailable() + totalWorkforceRefund,
				kingdom.getAreaAvailable() + totalAreaRefund);
		return "processed";
	}
	
	
	@GetMapping("/units")
	public @ResponseBody Object[] getUnits(@RequestParam String id) {
		//TODO check params validity
		ArrayList<ArmyView> units = new ArrayList<ArmyView>(armyViewRepository.findByKingdomID(Long.decode(id)));
		System.out.println("Units data loaded and sent to " + id);
		return units.toArray(new ArmyView[0]);
	}
	
	
	@GetMapping("/turn")
	public @ResponseBody String makeTurn(@RequestParam String id) {
		Long longID = Long.decode(id);
		if (longID != 0) 
			playTurn(longID);
		else {
			List<Kingdom> kingdoms = kingdomRepository.findAll();
			for (int i = 0; i < kingdoms.size(); i++) {
				playTurn(kingdoms.get(i).getId());
			}
		}
		return "processed";
	}
	
	/**
	 * Automatic turn for all kingdoms every 15 minutes (XX:00:00, XX:15:00, XX:30:00, XX:45:00)
	 */
	@Scheduled(cron="0 0/15 * * * *") 
	public void turnScheduler() {
		//makeTurn("0");
;	}
	
	/**
	 * Plays turn. Recalculates data.
	 * @param id of kingdom
	 */
	public void playTurn(Long id) {
		List<KingdomBuilding> kingdomBuilding = kingdomBuildingRepository.findByKingdomID(id);
		List<Building> buildings = buildingRepository.findAll();
		int totalGoldProduction = 0, totalMatProduction = 0, totalFoodProduction = 0, totalKnowledgeProduction = 0, totalWorkforceProduction = 0;
		int totalGoldStorage = 0, totalMatStorage = 0, totalFoodStorage = 0, totalKnowledgeStorage = 0, totalWorkforceStorage = 0;
		int totalGoldUpkeep = 0, totalMatUpkeep = 0, totalWorkforceUpkeep = 0;
		
		for (int i = 0; i < kingdomBuilding.size(); i++) {
			// build buildings
			Long buidiingId = Integer.toUnsignedLong(i) + 1;
			int buildingCount = kingdomBuilding.get(i).getBuildingsCount();
			int timeToCompleteAll = kingdomBuilding.get(i).getTimeToCompleteAll();
			if (timeToCompleteAll > 0) {
				timeToCompleteAll -= 1;
				kingdomBuildingRepository.setBuildingTimesAll(id, buidiingId, timeToCompleteAll);
				if ((timeToCompleteAll % buildingRepository.findByBuildingId(buidiingId).getBuildTime()) == 0) {
					kingdomBuildingRepository.setNumOfBuilding(id, buidiingId, buildingCount + 1);
				}
			}
			// calculate production/storage/upkeep
			totalGoldProduction += calculateResourcesProduction(buildings.get(i).getGoldProdMin(), buildings.get(i).getGoldProdMax(), buildingCount);
			totalMatProduction += calculateResourcesProduction(buildings.get(i).getMaterialProdMin(), buildings.get(i).getMaterialProdMax(), buildingCount);
			totalFoodProduction += calculateResourcesProduction(buildings.get(i).getFoodProdMin(), buildings.get(i).getFoodProdMax(), buildingCount);
			totalKnowledgeProduction += calculateResourcesProduction(buildings.get(i).getKnowledgeProdMin(), buildings.get(i).getKnowledgeProdMax(), buildingCount);
			totalWorkforceProduction += calculateResourcesProduction(buildings.get(i).getWorkforceProdMin(), buildings.get(i).getWorkforceProdMax(), buildingCount);
			
			totalGoldStorage += buildings.get(i).getGoldStorage() * buildingCount;
			totalMatStorage += buildings.get(i).getMaterialStorage() * buildingCount;
			totalFoodStorage += buildings.get(i).getFoodStorage() * buildingCount;
			totalKnowledgeStorage += buildings.get(i).getKnowledgeStorage() * buildingCount;
			totalWorkforceStorage += buildings.get(i).getWorkforceStorage() * buildingCount;
			
			totalGoldUpkeep += buildings.get(i).getGoldUpkeep() * buildingCount; // add units upkeep to this
			totalMatUpkeep += buildings.get(i).getMaterialUpkeep() * buildingCount;
			totalWorkforceUpkeep += buildings.get(i).getWorkforceUpkeep() * buildingCount;
			// food upkeep only for units (including workforce)
		}
		// calculate storage overflow and update kingdom repository
		Kingdom kingdom = kingdomRepository.findByKingdomId(id);
		kingdomRepository.updateKingdomResources(id,
				kingdom.getGoldAvailable() + calculateResourceOverflow(id, kingdom.getGoldAvailable(), totalGoldStorage, totalGoldProduction, totalGoldUpkeep),
				kingdom.getMaterialAvailable() + calculateResourceOverflow(id, kingdom.getMaterialAvailable(), totalMatStorage, totalMatProduction, totalMatUpkeep),
				kingdom.getFoodAvailable() + calculateResourceOverflow(id, kingdom.getFoodAvailable(), totalFoodStorage, totalFoodProduction, 0),
				kingdom.getKnowledgeAvailable() + calculateResourceOverflow(id, kingdom.getKnowledgeAvailable(), totalKnowledgeStorage, totalKnowledgeProduction, 0),
				kingdom.getWorkforceAvailable() + calculateResourceOverflow(id, kingdom.getWorkforceAvailable(), totalWorkforceStorage, totalWorkforceProduction, totalWorkforceUpkeep),
				kingdom.getAreaAvailable()
				);
		kingdomRepository.updateKingdomProduction(id,
				calculateResourceOverflow(id, kingdom.getGoldAvailable(), totalGoldStorage, totalGoldProduction, totalGoldUpkeep),
				calculateResourceOverflow(id, kingdom.getMaterialAvailable(), totalMatStorage, totalMatProduction, totalMatUpkeep),
				calculateResourceOverflow(id, kingdom.getFoodAvailable(), totalFoodStorage, totalFoodProduction, 0),
				calculateResourceOverflow(id, kingdom.getKnowledgeAvailable(), totalKnowledgeStorage, totalKnowledgeProduction, 0),
				calculateResourceOverflow(id, kingdom.getWorkforceAvailable(), totalWorkforceStorage, totalWorkforceProduction, totalWorkforceUpkeep)
				);

		// build/generate units

		// attack/defense, including spying, attack spells
		
	}
	
	/**
	 * Calculates total resource production from buildings.
	 * @param minProduction - minimal building production
	 * @param maxProduction - maximal building production
	 * @param buildingCount - number of buildings
	 * @return random resource production between min/max
	 */
	public int calculateResourcesProduction(int minProduction, int maxProduction, int buildingCount) {	
		int minGoldProd = minProduction * buildingCount;
		int maxGoldProd = maxProduction * buildingCount;
		Random r = new Random();
		return r.nextInt(maxGoldProd + 1 - minGoldProd) + minGoldProd;
	}
	
	/**
	 * Calculated how much resource is produced based on production/upkeep and storage overflow. After that it updates kingdom resource
	 * and production parameters.
	 * @param id of kingdom
	 * @param availableResource of kingdom
	 * @param storage of kingdom
	 * @param production of kingdom
	 * @param upkeep of kingdom
	 */
	public int calculateResourceOverflow(Long id, int availableResource, int storage, int production, int upkeep) {
		int resourceOverflowPer = 0;
		int freeStorage = storage - availableResource;
		int overflowDischarge = 0;
		if (freeStorage < 0) {
			if (storage != 0)
				resourceOverflowPer = Math.abs(freeStorage) * 100 / storage;
			else
				resourceOverflowPer = Math.abs(freeStorage) * 100 / 1;
			overflowDischarge = freeStorage / 3;
			if (resourceOverflowPer < 20)
				overflowDischarge += production * (20 - resourceOverflowPer) / 20;
			System.out.println("Resource: " + availableResource + "/" + storage + " Upkeep: " + upkeep + " Production: " + production);
			System.out.println("Overflow discharge: " + overflowDischarge + " overflow%: " + resourceOverflowPer);
			return overflowDischarge - upkeep;
		} 
		else {
			System.out.println("Resource: " + availableResource + "/" + storage + " Upkeep: " + upkeep + " Production: " + production);
			System.out.println("Overflow discharge: " + overflowDischarge + " overflow%: " + resourceOverflowPer);
			return production - upkeep;
		}
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}