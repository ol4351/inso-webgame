package com.webservice.main.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class KingdomUnitKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "kingdom_id")
	Long kingdomID;
	
	@Column(name = "unit_id")
	Long unitID;

	public KingdomUnitKey() {
		
	}
	
	public KingdomUnitKey(Long kingdomID, Long unitID) {
		this.kingdomID = kingdomID;
		this.unitID = unitID;
	}

	public Long getKingdomID() {
		return kingdomID;
	}

	public void setKingdomID(Long kingdomID) {
		this.kingdomID = kingdomID;
	}

	public Long getUnitID() {
		return unitID;
	}

	public void setUnitID(Long unitID) {
		this.unitID = unitID;
	}

	@Override
	public int hashCode() {
		final int prime = 53;
		int result = 1;
		result = prime * result + ((unitID == null) ? 0 : unitID.hashCode());
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
		KingdomUnitKey other = (KingdomUnitKey) obj;
		if (unitID == null) {
			if (other.unitID != null)
				return false;
		} else if (!unitID.equals(other.unitID))
			return false;
		if (kingdomID == null) {
			if (other.kingdomID != null)
				return false;
		} else if (!kingdomID.equals(other.kingdomID))
			return false;
		return true;
	}
}

