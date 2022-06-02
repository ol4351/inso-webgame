package com.webservice.main.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class KingdomUnit {
	@EmbeddedId
	KingdomUnitKey id;
	
	@ManyToOne
	@MapsId("kingdomID")
	@JoinColumn(name = "kingdom_id")
	Kingdom kingdom;
	
	@ManyToOne
	@MapsId("unitID")
	@JoinColumn(name = "unit_id")
	Unit unit;
	
	int unitsCount;
	int timeToCompleteAll;
	
	public KingdomUnit() { }
	
	public KingdomUnit(Kingdom kingdom, Unit unit, int unitsCount, int timeToCompleteAll) {
		this.kingdom = kingdom;
		this.unit = unit;
		this.unitsCount = unitsCount;
		this.timeToCompleteAll = timeToCompleteAll;
	}

	public KingdomUnitKey getId() {
		return id;
	}

	public void setId(KingdomUnitKey id) {
		this.id = id;
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
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
}
