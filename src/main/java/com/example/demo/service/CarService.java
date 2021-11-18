package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Car;
import com.example.demo.repo.CarRepo;

@Service
public class CarService {
	private CarRepo repo;

	public CarService(CarRepo repo) {
		this.repo = repo;
		}

	
	// Create
		public Car create(Car car) {
			return this.repo.saveAndFlush(car);
			
		}
		
		// Read All
		public List<Car> getAll() {
			
			return this.repo.findAll();
		}
		
		// Read By Id
		public Car getById(Long id) {
			return this.repo.findById(id).get();
		}
		
		// Custom Query - Find by Reg number
		public List <Car> getByRegNumber(String regNumber) {
			return this.repo.findCarByRegNumber(regNumber);
			
			
		}
		
		// Update
	    public Car updateCar(Long id, Car car) {
	    	Car existing = this.repo.findById(id).get();
	    	existing.setRegNumber(car.getRegNumber());
	    	existing.setCarName(car.getCarName());
	    	return this.repo.saveAndFlush(existing);
	    }

	    public boolean delete(Long id) {
	        
	         this.repo.deleteById(id);
	         
	        return !this.repo.existsById(id); //True or False
}



		
		}
