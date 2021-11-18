package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long garageId;
	
	
	@Column(nullable = false)
	private String garageName;
	
	@Column(unique = true, nullable = false)
	private String garageLocation;

	public Garage(String garageName, String garageLocation) {
		super();
		this.garageName = garageName;
		this.garageLocation = garageLocation;
	}

	public Garage(long garageId, String garageName, String garageLocation) {
		super();
		this.garageId = garageId;
		this.garageName = garageName;
		this.garageLocation = garageLocation;
	}

	public Garage() {
		super();
	}

	public long getGarageId() {
		return garageId;
	}

	public void setGarageId(long garageId) {
		this.garageId = garageId;
	}

	public String getGarageName() {
		return garageName;
	}

	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}

	public String getGarageLocation() {
		return garageLocation;
	}

	public void setGarageLocation(String garageLocation) {
		this.garageLocation = garageLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (garageId ^ (garageId >>> 32));
		result = prime * result + ((garageLocation == null) ? 0 : garageLocation.hashCode());
		result = prime * result + ((garageName == null) ? 0 : garageName.hashCode());
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
		Garage other = (Garage) obj;
		if (garageId != other.garageId)
			return false;
		if (garageLocation == null) {
			if (other.garageLocation != null)
				return false;
		} else if (!garageLocation.equals(other.garageLocation))
			return false;
		if (garageName == null) {
			if (other.garageName != null)
				return false;
		} else if (!garageName.equals(other.garageName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Garage [garageId=" + garageId + ", garageName=" + garageName + ", garageLocation=" + garageLocation
				+ "]";
	}

	
	
}
