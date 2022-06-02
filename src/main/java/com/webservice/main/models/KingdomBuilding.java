package com.webservice.main.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class KingdomBuilding {
	@EmbeddedId
	KingdomBuildingKey id;
	
	@ManyToOne
	@MapsId("kingdomID")
	@JoinColumn(name = "kingdom_id")
	Kingdom kingdom;
	
	@ManyToOne
	@MapsId("buildingID")
	@JoinColumn(name = "building_id")
	Building building;
	
	int buildingsCount;
	int timeToCompleteAll;
	
	public KingdomBuilding() { }
	
	public KingdomBuilding(Kingdom kingdom, Building building, int buildingsCount, int timeToCompleteAll) {
		this.kingdom = kingdom;
		this.building = building;
		this.buildingsCount = buildingsCount;
		this.timeToCompleteAll = timeToCompleteAll;
	}

	public KingdomBuildingKey getId() {
		return id;
	}

	public void setId(KingdomBuildingKey id) {
		this.id = id;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
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
}
