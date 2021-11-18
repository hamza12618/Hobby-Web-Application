package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.domain.Garage;

@Repository
public interface GarageRepo extends JpaRepository<Garage, Long>{
	
	@Query(value = "SELECT * FROM garage WHERE garageLocation = ?1", nativeQuery = true)
	Optional<Garage> findBygarageLocation(String garageLocation);
}
