package com.webservice.main.models;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kingdoms")
public class Kingdom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name; // should be unique
	private Long rulerId; // one to one
	private Long raceId; // many to one
	private int goldAvailable;
	private int goldProduction;
	private int materialAvailable;
	private int materialProduction;
	private int foodAvailable;
	private int foodProduction;
	private int workforceAvailable;
	private int workforceProduction;
	private int manaAvailable;
	private int manaProduction;
	private int knowledgeAvailable;
	private int knowledgeProduction;
	private int armorAvailable;
	private int armorProduction;
	private int weaponAvailable;
	private int weaponProduction;
	private int area;
	private int areaAvailable;
	private int prestige;
	private int turnsAvailable;

	@OneToMany(mappedBy = "kingdom")
	private Set<KingdomBuilding> buildings;
	
	public Kingdom() { }
	
	public Kingdom(String name, Long rulerId, Long raceId, int goldAvailable, int goldProduction, int materialAvailable,
			int materialProduction, int foodAvailable, int foodProduction, int workforceAvailable,
			int workforceProduction, int manaAvailable, int manaProduction, int knowledgeAvailable,
			int knowledgeProduction, int armorAvailable, int armorProduction, int weaponAvailable, int weaponProduction,
			int area, int areaAvailable, int prestige, int turnsAvailable, Set<KingdomBuilding> buildings) {
		this.name = name;
		this.rulerId = rulerId;
		this.raceId = raceId;
		this.goldAvailable = goldAvailable;
		this.goldProduction = goldProduction;
		this.materialAvailable = materialAvailable;
		this.materialProduction = materialProduction;
		this.foodAvailable = foodAvailable;
		this.foodProduction = foodProduction;
		this.workforceAvailable = workforceAvailable;
		this.workforceProduction = workforceProduction;
		this.manaAvailable = manaAvailable;
		this.manaProduction = manaProduction;
		this.knowledgeAvailable = knowledgeAvailable;
		this.knowledgeProduction = knowledgeProduction;
		this.armorAvailable = armorAvailable;
		this.armorProduction = armorProduction;
		this.weaponAvailable = weaponAvailable;
		this.weaponProduction = weaponProduction;
		this.area = area;
		this.areaAvailable = areaAvailable;
		this.prestige = prestige;
		this.turnsAvailable = turnsAvailable;
		this.buildings = buildings;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getRulerId() {
		return rulerId;
	}

	public void setRulerId(Long rulerId) {
		this.rulerId = rulerId;
	}

	public Long getRaceId() {
		return raceId;
	}

	public void setRaceId(Long raceId) {
		this.raceId = raceId;
	}

	public int getGoldAvailable() {
		return goldAvailable;
	}

	public void setGoldAvailable(int goldAvailable) {
		this.goldAvailable = goldAvailable;
	}

	public int getGoldProduction() {
		return goldProduction;
	}

	public void setGoldProduction(int goldProduction) {
		this.goldProduction = goldProduction;
	}

	public int getMaterialAvailable() {
		return materialAvailable;
	}

	public void setMaterialAvailable(int materialAvailable) {
		this.materialAvailable = materialAvailable;
	}

	public int getMaterialProduction() {
		return materialProduction;
	}

	public void setMaterialProduction(int materialProduction) {
		this.materialProduction = materialProduction;
	}

	public int getFoodAvailable() {
		return foodAvailable;
	}

	public void setFoodAvailable(int foodAvailable) {
		this.foodAvailable = foodAvailable;
	}

	public int getFoodProduction() {
		return foodProduction;
	}

	public void setFoodProduction(int foodProduction) {
		this.foodProduction = foodProduction;
	}

	public int getWorkforceAvailable() {
		return workforceAvailable;
	}

	public void setWorkforceAvailable(int workforceAvailable) {
		this.workforceAvailable = workforceAvailable;
	}

	public int getWorkforceProduction() {
		return workforceProduction;
	}

	public void setWorkforceProduction(int workforceProduction) {
		this.workforceProduction = workforceProduction;
	}

	public int getManaAvailable() {
		return manaAvailable;
	}

	public void setManaAvailable(int manaAvailable) {
		this.manaAvailable = manaAvailable;
	}

	public int getManaProduction() {
		return manaProduction;
	}

	public void setManaProduction(int manaProduction) {
		this.manaProduction = manaProduction;
	}

	public int getKnowledgeAvailable() {
		return knowledgeAvailable;
	}

	public void setKnowledgeAvailable(int knowledgeAvailable) {
		this.knowledgeAvailable = knowledgeAvailable;
	}

	public int getKnowledgeProduction() {
		return knowledgeProduction;
	}

	public void setKnowledgeProduction(int knowledgeProduction) {
		this.knowledgeProduction = knowledgeProduction;
	}

	public int getArmorAvailable() {
		return armorAvailable;
	}

	public void setArmorAvailable(int armorAvailable) {
		this.armorAvailable = armorAvailable;
	}

	public int getArmorProduction() {
		return armorProduction;
	}

	public void setArmorProduction(int armorProduction) {
		this.armorProduction = armorProduction;
	}

	public int getWeaponAvailable() {
		return weaponAvailable;
	}

	public void setWeaponAvailable(int weaponAvailable) {
		this.weaponAvailable = weaponAvailable;
	}

	public int getWeaponProduction() {
		return weaponProduction;
	}

	public void setWeaponProduction(int weaponProduction) {
		this.weaponProduction = weaponProduction;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}
	
	public int getAreaAvailable() {
		return areaAvailable;
	}

	public void setAreaAvailable(int areaAvailable) {
		this.areaAvailable = areaAvailable;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	public int getTurnsAvailable() {
		return turnsAvailable;
	}

	public void setTurnsAvailable(int turnsAvailable) {
		this.turnsAvailable = turnsAvailable;
	}

	public Set<KingdomBuilding> getBuildings() {
		return Collections.unmodifiableSet(buildings);
	}

	public void setBuildings(Set<KingdomBuilding> buildings) {
		this.buildings.clear();
		this.buildings.addAll(buildings);
	}
}
