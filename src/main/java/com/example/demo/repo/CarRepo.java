package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Car;






@Repository
public interface CarRepo extends JpaRepository<Car, Long>{
	
	@Query(value = "SELECT * FROM car WHERE RegNumber = ?1", nativeQuery = true)
	Optional<Car> findByRegNumber(String RegNumber);
}
