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

import com.example.demo.domain.Car;

import com.example.demo.service.CarService;

@RestController
@RequestMapping("/car") // http://localhost:9000/car/...
public class CarController {

	private CarService service;
	
	public CarController(CarService service) {
		this.service = service;
	
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello, World";
	}
	
	// Create 
	@PostMapping("/create")
	public ResponseEntity<Car> create(@RequestBody Car car) {
		
		return new ResponseEntity<Car>(this.service.create(car), HttpStatus.CREATED);
		
		
	}
	
	// Read
	@GetMapping("/getAll")
	public ResponseEntity<List<Car>> getAll() {
		return new ResponseEntity<List<Car>>(this.service.getAll(), HttpStatus.ACCEPTED);
	}
	
	//Read by ID
	@GetMapping("/getBycarId/{id}")
	public ResponseEntity<Car> getOne(@PathVariable Long id) {
		return new ResponseEntity<Car>(this.service.getById(id), HttpStatus.OK);
	}
	
	// Custom Query - Get by Reg number
	@GetMapping("/getByRegNumber/{regNumber}")
	public ResponseEntity<Car> getByRegNumber(@PathVariable String regNumber) {
		return new ResponseEntity<Car>(this.service.getByRegNumber(regNumber), HttpStatus.ACCEPTED);
	}
	
	
	//Update 
	@PutMapping("/update/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id")Long id, @RequestBody Car car) {
//		this.accounts.remove(id);
//		this.accounts.add(id,account);
		return new ResponseEntity<Car>(this.service.updateCar(id, car), HttpStatus.ACCEPTED);
	}
	
	
	//Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Car> delete(@PathVariable Long id) {
//		if (this.service.delete(id) == true) {
//			
//		return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
//	} else {
//		return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
		return this.service.delete(id) ? new ResponseEntity<Car>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Car>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	
	
	
	
	
}
