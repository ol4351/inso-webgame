package com.webservice.main.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "units")
public class Unit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long raceID; // many to one
	private String name; // should be unique
	private int hp;
	private int att;
	private int siegeAtt;
	private int def;
	private int size;
	private int speed;
	private int goldCost;
	private int goldUpkeep;
	private int foodUpkeep;
	private int weaponCost;
	private int armorCost;
	private int manaCost;
	private int manaUpkeep;
	private int workforceUpkeep;
	private int buildTime;
	
	public Unit(Long raceID, String name, int hp, int att, int siegeAtt, int def, int size, int speed, int goldCost,
			int goldUpkeep, int foodUpkeep, int weaponCost, int armorCost, int manaCost, int manaUpkeep, int workforceUpkeep, int buildTime) {
		this.raceID = raceID;
		this.name = name;
		this.hp = hp;
		this.att = att;
		this.siegeAtt = siegeAtt;
		this.def = def;
		this.size = size;
		this.speed = speed;
		this.goldCost = goldCost;
		this.goldUpkeep = goldUpkeep;
		this.foodUpkeep = foodUpkeep;
		this.weaponCost = weaponCost;
		this.armorCost = armorCost;
		this.manaCost = manaCost;
		this.manaUpkeep = manaUpkeep;
		this.workforceUpkeep = workforceUpkeep;
		this.buildTime = buildTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRaceID() {
		return raceID;
	}

	public void setRaceID(Long raceID) {
		this.raceID = raceID;
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
		return this.buildTime;
	}
	
	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}
}
