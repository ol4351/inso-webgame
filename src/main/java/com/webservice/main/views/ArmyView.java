package com.webservice.main.views;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import com.webservice.main.models.KingdomUnitKey;

@Entity
@Immutable
@Table(name = "armyview")
public class ArmyView {
	//========================= KingdomArmy table =============
	
	@EmbeddedId
	KingdomUnitKey id;
	
	@Column(name = "units_count")
	private int unitsCount;
	
	@Column(name = "time_to_complete_all")
	private int timeToCompleteAll;
		
	//========================== Army table ===================
	
	@Column(name = "raceid")
	private String race;	//
	@Column(name = "name")
	private String name;	
	@Column(name = "hp")
	private int hp;
	@Column(name = "att")
	private int att;
	@Column(name = "siege_att")
	private int siegeAtt;
	@Column(name = "def")
	private int def;
	@Column(name = "size")
	private int size;
	@Column(name = "speed")
	private int speed;
	@Column(name = "gold_cost")
	private int goldCost;
	@Column(name = "gold_upkeep")
	private int goldUpkeep;
	@Column(name = "food_upkeep")
	private int foodUpkeep;
	@Column(name = "weapon_cost")
	private int weaponCost;
	@Column(name = "armor_cost")
	private int armorCost;
	@Column(name = "mana_cost")
	private int manaCost;
	@Column(name = "mana_upkeep")
	private int manaUpkeep;
	@Column(name = "workforce_upkeep")
	private int workforceUpkeep;
	@Column(name = "build_time")
	private int buildTime;
	
	public KingdomUnitKey getId() {
		return id;
	}
	public void setId(KingdomUnitKey id) {
		this.id = id;
	}
	public int getUnitsCount() {
		return unitsCount;
	}
	public void setUnitsCount(int unitsCount) {
		this.unitsCount = unitsCount;
	}
	public int getTimeToCompleteAll() {
		return timeToCompleteAll;
	}
	public void setTimeToCompleteAll(int timeToCompleteAll) {
		this.timeToCompleteAll = timeToCompleteAll;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getSiegeAtt() {
		return siegeAtt;
	}
	public void setSiegeAtt(int siegeAtt) {
		this.siegeAtt = siegeAtt;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getGoldCost() {
		return goldCost;
	}
	public void setGoldCost(int goldCost) {
		this.goldCost = goldCost;
	}
	public int getGoldUpkeep() {
		return goldUpkeep;
	}
	public void setGoldUpkeep(int goldUpkeep) {
		this.goldUpkeep = goldUpkeep;
	}
	public int getFoodUpkeep() {
		return foodUpkeep;
	}
	public void setFoodUpkeep(int foodUpkeep) {
		this.foodUpkeep = foodUpkeep;
	}
	public int getWeaponCost() {
		return weaponCost;
	}
	public void setWeaponCost(int weaponCost) {
		this.weaponCost = weaponCost;
	}
	public int getArmorCost() {
		return armorCost;
	}
	public void setArmorCost(int armorCost) {
		this.armorCost = armorCost;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public int getManaUpkeep() {
		return manaUpkeep;
	}
	public void setManaUpkeep(int manaUpkeep) {
		this.manaUpkeep = manaUpkeep;
	}
	public int getWorkforceUpkeep() {
		return workforceUpkeep;
	}
	public void setWorkforceUpkeep(int workforceUpkeep) {
		this.workforceUpkeep = workforceUpkeep;
	}
	public int getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}
}
