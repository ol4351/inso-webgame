package com.webservice.main.views;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.webservice.main.models.KingdomBuildingKey;

@Entity
@Immutable
@Table(name = "buildingsview")
public class BuildingView {
	
	//========================= KingdomBuilding table =============
	
	@EmbeddedId
	KingdomBuildingKey id;
	
	@Column(name = "buildings_count")
	private int buildingsCount;
	
	@Column(name = "time_to_complete_all")
	private int timeToCompleteAll;
	
	//========================== Building table ===================
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "armor_prod_min")
	private int armorProdMin;
	@Column(name = "armor_prod_max")
	private int armorProdMax;
	@Column(name = "armor_storage")
	private int armorStorage;

	@Column(name = "att")
	private int att;
	
	@Column(name = "def")
	private int def;

	@Column(name = "food_prod_min")
	private int foodProdMin;
	@Column(name = "food_prod_max")
	private int foodProdMax;
	@Column(name = "food_storage")
	private int foodStorage;
	
	@Column(name = "gold_cost")
	private int goldCost;
	@Column(name = "gold_prod_min")
	private int goldProdMin;
	@Column(name = "gold_prod_max")
	private int goldProdMax;
	@Column(name = "gold_storage")
	private int goldStorage;
	@Column(name = "gold_upkeep")
	private int goldUpkeep;
	
	@Column(name = "hp")
	private int hp;

	@Column(name = "knowledge_prod_min")
	private int knowledgeProdMin;
	@Column(name = "knowledge_prod_max")
	private int knowledgeProdMax;
	@Column(name = "knowledge_storage")
	private int knowledgeStorage;
	
	@Column(name = "material_cost")
	private int materialCost;
	@Column(name = "material_prod_min")
	private int materialProdMin;
	@Column(name = "material_prod_max")
	private int materialProdMax;
	@Column(name = "material_storage")
	private int materialStorage;
	@Column(name = "material_upkeep")
	private int materialUpkeep;
	
	@Column(name = "weapon_prod_min")
	private int weaponProdMin;
	@Column(name = "weapon_prod_max")
	private int weaponProdMax;
	@Column(name = "weapon_storage")
	private int weaponStorage;
	
	@Column(name = "workforce_prod_min")
	private int workforceProdMin;
	@Column(name = "workforce_prod_max")
	private int workforceProdMax;
	@Column(name = "workforce_storage")
	private int workforceStorage;
	@Column(name = "workforce_upkeep")
	private int workforceUpkeep;

	@Column(name = "area_upkeep")
	private int areaUpkeep;
	
	@Column(name = "build_time")
	private int buildTime;
	
	@Column(name = "unit_storage")
	private int unitStorage;

	public KingdomBuildingKey getId() {
		return id;
	}

	public void setId(KingdomBuildingKey id) {
		this.id = id;
	}

	public int getBuildingsCount() {
		return buildingsCount;
	}

	public void setBuildingsCount(int buildingsCount) {
		this.buildingsCount = buildingsCount;
	}

	public int getTimeToCompleteAll() {
		return timeToCompleteAll;
	}

	public void setTimeToCompleteAll(int timeToCompleteAll) {
		this.timeToCompleteAll = timeToCompleteAll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getGoldStorage() {
		return goldStorage;
	}

	public void setGoldStorage(int goldStorage) {
		this.goldStorage = goldStorage;
	}

	public int getGoldUpkeep() {
		return goldUpkeep;
	}

	public void setGoldUpkeep(int goldUpkeep) {
		this.goldUpkeep = goldUpkeep;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	public int getMaterialStorage() {
		return materialStorage;
	}

	public void setMaterialStorage(int materialStorage) {
		this.materialStorage = materialStorage;
	}

	public int getMaterialUpkeep() {
		return materialUpkeep;
	}

	public void setMaterialUpkeep(int materialUpkeep) {
		this.materialUpkeep = materialUpkeep;
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

	public int getWorkforceStorage() {
		return workforceStorage;
	}

	public void setWorkforceStorage(int workforceStorage) {
		this.workforceStorage = workforceStorage;
	}

	public int getWorkforceUpkeep() {
		return workforceUpkeep;
	}

	public void setWorkforceUpkeep(int workforceUpkeep) {
		this.workforceUpkeep = workforceUpkeep;
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
}
