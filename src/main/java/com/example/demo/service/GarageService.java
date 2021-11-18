package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Garage;
import com.example.demo.repo.GarageRepo;

@Service
public class GarageService {
	
	private GarageRepo repo;

	public GarageService(GarageRepo repo) {
		this.repo = repo;
		}

	
	// Create
		public Garage create(Garage garage) {
			return this.repo.saveAndFlush(garage);
			
		}
		
		// Read All
		public List<Garage> getAll() {
			
			return this.repo.findAll();
		}
		
		// Read By Id
		public Garage getById(Long id) {
			return this.repo.findById(id).get();
		}
		
		// Custom Query - Find by garage Location
		public Garage getBygarageLocation(String garageLocation) {
			return this.repo.findBygarageLocation(garageLocation).get();
			
			
		}
		
		// Update
	    public Garage updateGarage(Long id, Garage garage) {
	    	Garage existing = this.repo.findById(id).get();
	    	existing.setGarageName(garage.getGarageName());
	    	existing.setGarageLocation(garage.getGarageLocation());
	    	return this.repo.saveAndFlush(existing);
	    }

	    public boolean delete(Long id) {
	        
	         this.repo.deleteById(id);
	         
	        return !this.repo.existsById(id); //True or False
}



}
