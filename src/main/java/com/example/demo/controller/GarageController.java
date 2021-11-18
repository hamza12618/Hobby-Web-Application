package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Garage;
import com.example.demo.service.GarageService;

@RestController
@RequestMapping("/garage") // http://localhost:9000/garage/...
public class GarageController {

	
private GarageService service;
	
	public GarageController(GarageService service) {
		this.service = service;
	
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, World";
	}
	
	// Create 
	@PostMapping("/create")
	public ResponseEntity<Garage> create(@RequestBody Garage garage) {
		
		return new ResponseEntity<Garage>(this.service.create(garage), HttpStatus.CREATED);
		
		
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Garage>> getAll() {
		return new ResponseEntity<List<Garage>>(this.service.getAll(), HttpStatus.ACCEPTED);
	}
	
	//Read by ID
	@GetMapping("/getBygarageId/{id}")
	public ResponseEntity<Garage> getOne(@PathVariable Long id) {
		return new ResponseEntity<Garage>(this.service.getById(id), HttpStatus.OK);
	}
	
	// Custom Query - Get by Reg number
	@GetMapping("/getBygarageLocation/{garageLocation}")
	public ResponseEntity <List <Garage>> getBygarageLocation(@PathVariable String garageLocation) {
		return new ResponseEntity <List <Garage>>(this.service.getBygarageLocation(garageLocation), HttpStatus.ACCEPTED);
	}
	
	
	//Update 
	@PutMapping("/update/{id}")
	public ResponseEntity<Garage> updateGarage(@PathVariable("id")Long id, @RequestBody Garage garage) {
//		this.accounts.remove(id);
//		this.accounts.add(id,account);
		return new ResponseEntity<Garage>(this.service.updateGarage(id, garage), HttpStatus.ACCEPTED);
	}
	
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Garage> delete(@PathVariable Long id) {
//		if (this.service.delete(id) == true) {
//			
//		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
//	} else {
//		return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
		return this.service.delete(id) ? new ResponseEntity<Garage>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Garage>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	
}
