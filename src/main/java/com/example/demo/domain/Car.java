package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carId;
	
	
	@Column(nullable = false)
	private String carName;
	
	@Column(unique = true, nullable = false)
	private String regNumber;
	
	@ManyToOne

	private Garage garage;

	public Car(String carName, String regNumber) {
		super();
		this.carName = carName;
		this.regNumber = regNumber;
	}

	public Car(long carId, String carName, String regNumber) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.regNumber = regNumber;
		
	}

	public Car() {
		super();
	}

	public long getCarId() {
		return carId;
	}

	public void setCarId(long carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (carId ^ (carId >>> 32));
		result = prime * result + ((carName == null) ? 0 : carName.hashCode());
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
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
		Car other = (Car) obj;
		if (carId != other.carId)
			return false;
		if (carName == null) {
			if (other.carName != null)
				return false;
		} else if (!carName.equals(other.carName))
			return false;
		if (regNumber == null) {
			if (other.regNumber != null)
				return false;
		} else if (!regNumber.equals(other.regNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CarDomain [carId=" + carId + ", carName=" + carName + ", regNumber=" + regNumber + "]";
	}
	
	
	
}
