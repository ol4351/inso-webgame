package com.webservice.main.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class KingdomBuildingKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "kingdom_id")
	Long kingdomID;
	
	@Column(name = "building_id")
	Long buildingID;

	public KingdomBuildingKey() {
		
	}
	
	public KingdomBuildingKey(Long kingdomID, Long buildingID) {
		this.kingdomID = kingdomID;
		this.buildingID = buildingID;
	}

	public Long getKingdomID() {
		return kingdomID;
	}

	public void setKingdomID(Long kingdomID) {
		this.kingdomID = kingdomID;
	}

	public Long getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(Long buildingID) {
		this.buildingID = buildingID;
	}

	@Override
	public int hashCode() {
		final int prime = 47;
		int result = 1;
		result = prime * result + ((buildingID == null) ? 0 : buildingID.hashCode());
		result = prime * result + ((kingdomID == null) ? 0 : kingdomID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KingdomBuildingKey other = (KingdomBuildingKey) obj;
		if (buildingID == null) {
			if (other.buildingID != null)
				return false;
		} else if (!buildingID.equals(other.buildingID))
			return false;
		if (kingdomID == null) {
			if (other.kingdomID != null)
				return false;
		} else if (!kingdomID.equals(other.kingdomID))
			return false;
		return true;
	}
}
