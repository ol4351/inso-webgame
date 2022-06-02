package com.webservice.main.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "buildings")
public class Building {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private EBuilding name;
	
	private int goldCost;
	private int goldProdMin;
	private int goldProdMax;
	private int goldUpkeep;
	private int goldStorage;
	private int materialCost;
	private int materialProdMin;
	private int materialProdMax;
	private int materialUpkeep;
	private int materialStorage;
	private int foodProdMin;
	private int foodProdMax;
	private int foodStorage;
	private int workforceProdMin;
	private int workforceProdMax;
	private int workforceUpkeep;
	private int workforceStorage;
	private int knowledgeProdMin;
	private int knowledgeProdMax;
	private int knowledgeStorage;
	private int armorProdMin;
	private int armorProdMax;
	private int armorStorage;
	private int weaponProdMin;
	private int weaponProdMax;
	private int weaponStorage;
	private int areaUpkeep;
	private int buildTime;
	private int unitStorage;
	private int hp;
	private int att;
	private int def;

	public Building() {
		
	}

	public Building(EBuilding name, int goldCost, int goldProdMin, int goldProdMax, int goldUpkeep, int goldStorage,
			int materialCost, int materialProdMin, int materialProdMax, int materialUpkeep, int materialStorage,
			int foodProdMin, int foodProdMax, int foodStorage, int workforceProdMin, int workforceProdMax,
			int workforceUpkeep, int workforceStorage, int knowledgeProdMin, int knowledgeProdMax, int knowledgeStorage,
			int armorProdMin, int armorProdMax, int armorStorage, int weaponProdMin, int weaponProdMax,
			int weaponStorage, int areaUpkeep, int buildTime, int unitStorage, int hp, int att, int def) {
		this.name = name;
		this.goldCost = goldCost;
		this.goldProdMin = goldProdMin;
		this.goldProdMax = goldProdMax;
		this.goldUpkeep = goldUpkeep;
		this.goldStorage = goldStorage;
		this.materialCost = materialCost;
		this.materialProdMin = materialProdMin;
		this.materialProdMax = materialProdMax;
		this.materialUpkeep = materialUpkeep;
		this.materialStorage = materialStorage;
		this.foodProdMin = foodProdMin;
		this.foodProdMax = foodProdMax;
		this.foodStorage = foodStorage;
		this.workforceProdMin = workforceProdMin;
		this.workforceProdMax = workforceProdMax;
		this.workforceUpkeep = workforceUpkeep;
		this.workforceStorage = workforceStorage;
		this.knowledgeProdMin = knowledgeProdMin;
		this.knowledgeProdMax = knowledgeProdMax;
		this.knowledgeStorage = knowledgeStorage;
		this.armorProdMin = armorProdMin;
		this.armorProdMax = armorProdMax;
		this.armorStorage = armorStorage;
		this.weaponProdMin = weaponProdMin;
		this.weaponProdMax = weaponProdMax;
		this.weaponStorage = weaponStorage;
		this.areaUpkeep = areaUpkeep;
		this.buildTime = buildTime;
		this.unitStorage = unitStorage;
		this.hp = hp;
		this.att = att;
		this.def = def;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EBuilding getName() {
		return name;
	}

	public void setName(EBuilding name) {
		this.name = name;
	}

	public int getGoldCost() {
		return goldCost;
	}

	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}

	public int getGoldProdMin() {
		return goldProdMin;
	}

	public void setGoldProdMin(int goldProdMin) {
		this.goldProdMin = goldProdMin;
	}

	public int getGoldProdMax() {
		return goldProdMax;
	}

	public void setGoldProdMax(int goldProdMax) {
		this.goldProdMax = goldProdMax;
	}

	public int getGoldUpkeep() {
		return goldUpkeep;
	}

	public void setGoldUpkeep(int goldUpkeep) {
		this.goldUpkeep = goldUpkeep;
	}

	public int getGoldStorage() {
		return goldStorage;
	}

	public void setGoldStorage(int goldStorage) {
		this.goldStorage = goldStorage;
	}

	public int getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(int materialCost) {
		this.materialCost = materialCost;
	}

	public int getMaterialProdMin() {
		return materialProdMin;
	}

	public void setMaterialProdMin(int materialProdMin) {
		this.materialProdMin = materialProdMin;
	}

	public int getMaterialProdMax() {
		return materialProdMax;
	}

	public void setMaterialProdMax(int materialProdMax) {
		this.materialProdMax = materialProdMax;
	}

	public int getMaterialUpkeep() {
		return materialUpkeep;
	}

	public void setMaterialUpkeep(int materialUpkeep) {
		this.materialUpkeep = materialUpkeep;
	}

	public int getMaterialStorage() {
		return materialStorage;
	}

	public void setMaterialStorage(int materialStorage) {
		this.materialStorage = materialStorage;
	}

	public int getFoodProdMin() {
		return foodProdMin;
	}

	public void setFoodProdMin(int foodProdMin) {
		this.foodProdMin = foodProdMin;
	}

	public int getFoodProdMax() {
		return foodProdMax;
	}

	public void setFoodProdMax(int foodProdMax) {
		this.foodProdMax = foodProdMax;
	}

	public int getFoodStorage() {
		return foodStorage;
	}

	public void setFoodStorage(int foodStorage) {
		this.foodStorage = foodStorage;
	}

	public int getWorkforceProdMin() {
		return workforceProdMin;
	}

	public void setWorkforceProdMin(int workforceProdMin) {
		this.workforceProdMin = workforceProdMin;
	}

	public int getWorkforceProdMax() {
		return workforceProdMax;
	}

	public void setWorkforceProdMax(int workforceProdMax) {
		this.workforceProdMax = workforceProdMax;
	}

	public int getWorkforceUpkeep() {
		return workforceUpkeep;
	}

	public void setWorkforceUpkeep(int workforceUpkeep) {
		this.workforceUpkeep = workforceUpkeep;
	}

	public int getWorkforceStorage() {
		return workforceStorage;
	}

	public void setWorkforceStorage(int workforceStorage) {
		this.workforceStorage = workforceStorage;
	}

	public int getKnowledgeProdMin() {
		return knowledgeProdMin;
	}

	public void setKnowledgeProdMin(int knowledgeProdMin) {
		this.knowledgeProdMin = knowledgeProdMin;
	}

	public int getKnowledgeProdMax() {
		return knowledgeProdMax;
	}

	public void setKnowledgeProdMax(int knowledgeProdMax) {
		this.knowledgeProdMax = knowledgeProdMax;
	}

	public int getKnowledgeStorage() {
		return knowledgeStorage;
	}

	public void setKnowledgeStorage(int knowledgeStorage) {
		this.knowledgeStorage = knowledgeStorage;
	}

	public int getArmorProdMin() {
		return armorProdMin;
	}

	public void setArmorProdMin(int armorProdMin) {
		this.armorProdMin = armorProdMin;
	}

	public int getArmorProdMax() {
		return armorProdMax;
	}

	public void setArmorProdMax(int armorProdMax) {
		this.armorProdMax = armorProdMax;
	}

	public int getArmorStorage() {
		return armorStorage;
	}

	public void setArmorStorage(int armorStorage) {
		this.armorStorage = armorStorage;
	}

	public int getWeaponProdMin() {
		return weaponProdMin;
	}

	public void setWeaponProdMin(int weaponProdMin) {
		this.weaponProdMin = weaponProdMin;
	}

	public int getWeaponProdMax() {
		return weaponProdMax;
	}

	public void setWeaponProdMax(int weaponProdMax) {
		this.weaponProdMax = weaponProdMax;
	}

	public int getWeaponStorage() {
		return weaponStorage;
	}

	public void setWeaponStorage(int weaponStorage) {
		this.weaponStorage = weaponStorage;
	}

	public int getAreaUpkeep() {
		return areaUpkeep;
	}

	public void setAreaUpkeep(int areaUpkeep) {
		this.areaUpkeep = areaUpkeep;
	}

	public int getBuildTime() {
		return buildTime;
	}

	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}
	
	public int getUnitStorage() {
		return this.unitStorage;
	}
	
	public void setUnitStorage(int unitStorage) {
		this.unitStorage = unitStorage;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
}
