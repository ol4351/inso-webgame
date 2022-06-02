package com.webservice.main.views;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "statusview")
public class StatusView {

	@Id
	private int id;
	
	@Column(name = "race_name")
	private String raceName;
	
	@Column(name = "name")
	private String kingdomName;
	
	@Column(name = "area")
	private int area;
	@Column(name = "area_available")
	private int areaAvailable;
	
	@Column(name = "armor_available")
	private int armorAvailable;	
	@Column(name = "armor_production")
	private int armorProduction;
	@Transient
	private int armorStorage;
	
	@Column(name = "food_available")
	private int foodAvailable;
	@Column(name = "food_production")
	private int foodProduction;
	@Transient
	private int foodConsumption;
	@Transient
	private int foodStorage;
	
	@Column(name = "gold_available")
	private int goldAvailable;
	@Column(name = "gold_production")
	private int goldProduction;
	@Transient
	private int goldConsumption;
	@Transient
	private int goldStorage;
	
	@Column(name = "knowledge_available")
	private int knowledgeAvailable;
	@Column(name = "knowledge_production")
	private int knowledgeProduction;
	@Transient
	private int knowledgeStorage;
	
	@Column(name = "mana_available")
	private int manaAvailable;
	@Column(name = "mana_production")
	private int manaProduction;
	@Transient
	private int manaConsumption;
	@Transient
	private int manaStorage;
	
	@Column(name = "material_available")
	private int materialAvailable;
	@Column(name = "material_production")
	private int materialProduction;
	@Transient
	private int materialConsumption;
	@Transient
	private int materialStorage;
	
	@Column(name = "prestige")
	private int prestige;
	
	@Column(name = "weapon_available")
	private int weaponAvailable;
	@Column(name = "weapon_production")
	private int weaponProduction;
	@Transient
	private int weaponStorage;
	
	@Column(name = "workforce_available")
	private int workforceAvailable;
	@Column(name = "workforce_production")
	private int workforceProduction;
	@Transient
	private int workforceStorage;
	
	@Column(name = "turns_available")
	private int turnsAvailable;

	public StatusView() { }
	
	public StatusView(String raceName, String kingdomName, int area, int areaAvailable, int armorAvailable,
			int armorProduction, int armorStorage, int foodAvailable, int foodProduction, int foodConsumption,
			int foodStorage, int goldAvailable, int goldProduction, int goldConsumption, int goldStorage,
			int knowledgeAvailable, int knowledgeProduction, int knowledgeStorage, int manaAvailable,
			int manaProduction, int manaConsumption, int manaStorage, int materialAvailable, int materialProduction,
			int materialConsumption, int materialStorage, int prestige, int weaponAvailable, int weaponProduction,
			int weaponStorage, int workforceAvailable, int workforceProduction, int workforceStorage,
			int turnsAvailable) {
		this.raceName = raceName;
		this.kingdomName = kingdomName;
		this.area = area;
		this.areaAvailable = areaAvailable;
		this.armorAvailable = armorAvailable;
		this.armorProduction = armorProduction;
		this.armorStorage = armorStorage;
		this.foodAvailable = foodAvailable;
		this.foodProduction = foodProduction;
		this.foodConsumption = foodConsumption;
		this.foodStorage = foodStorage;
		this.goldAvailable = goldAvailable;
		this.goldProduction = goldProduction;
		this.goldConsumption = goldConsumption;
		this.goldStorage = goldStorage;
		this.knowledgeAvailable = knowledgeAvailable;
		this.knowledgeProduction = knowledgeProduction;
		this.knowledgeStorage = knowledgeStorage;
		this.manaAvailable = manaAvailable;
		this.manaProduction = manaProduction;
		this.manaConsumption = manaConsumption;
		this.manaStorage = manaStorage;
		this.materialAvailable = materialAvailable;
		this.materialProduction = materialProduction;
		this.materialConsumption = materialConsumption;
		this.materialStorage = materialStorage;
		this.prestige = prestige;
		this.weaponAvailable = weaponAvailable;
		this.weaponProduction = weaponProduction;
		this.weaponStorage = weaponStorage;
		this.workforceAvailable = workforceAvailable;
		this.workforceProduction = workforceProduction;
		this.workforceStorage = workforceStorage;
		this.turnsAvailable = turnsAvailable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRaceName() {
		return raceName;
	}

	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}

	public String getKingdomName() {
		return kingdomName;
	}

	public void setKingdomName(String kingdomName) {
		this.kingdomName = kingdomName;
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

	public int getArmorStorage() {
		return armorStorage;
	}

	public void setArmorStorage(int armorStorage) {
		this.armorStorage = armorStorage;
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

	public int getFoodConsumption() {
		return foodConsumption;
	}

	public void setFoodConsumption(int foodConsumption) {
		this.foodConsumption = foodConsumption;
	}

	public int getFoodStorage() {
		return foodStorage;
	}

	public void setFoodStorage(int foodStorage) {
		this.foodStorage = foodStorage;
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

	public int getGoldConsumption() {
		return goldConsumption;
	}

	public void setGoldConsumption(int goldConsumption) {
		this.goldConsumption = goldConsumption;
	}

	public int getGoldStorage() {
		return goldStorage;
	}

	public void setGoldStorage(int goldStorage) {
		this.goldStorage = goldStorage;
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

	public int getKnowledgeStorage() {
		return knowledgeStorage;
	}

	public void setKnowledgeStorage(int knowledgeStorage) {
		this.knowledgeStorage = knowledgeStorage;
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

	public int getManaConsumption() {
		return manaConsumption;
	}

	public void setManaConsumption(int manaConsumption) {
		this.manaConsumption = manaConsumption;
	}

	public int getManaStorage() {
		return manaStorage;
	}

	public void setManaStorage(int manaStorage) {
		this.manaStorage = manaStorage;
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

	public int getMaterialConsumption() {
		return materialConsumption;
	}

	public void setMaterialConsumption(int materialConsumption) {
		this.materialConsumption = materialConsumption;
	}

	public int getMaterialStorage() {
		return materialStorage;
	}

	public void setMaterialStorage(int materialStorage) {
		this.materialStorage = materialStorage;
	}

	public int getPrestige() {
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
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

	public int getWeaponStorage() {
		return weaponStorage;
	}

	public void setWeaponStorage(int weaponStorage) {
		this.weaponStorage = weaponStorage;
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

	public int getWorkforceStorage() {
		return workforceStorage;
	}

	public void setWorkforceStorage(int workforceStorage) {
		this.workforceStorage = workforceStorage;
	}

	public int getTurnsAvailable() {
		return turnsAvailable;
	}

	public void setTurnsAvailable(int turnsAvailable) {
		this.turnsAvailable = turnsAvailable;
	}
}
