package com.example.demo.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.domain.Car;
import com.example.demo.domain.Garage;
import com.example.demo.repo.CarRepo;
import com.example.demo.repo.GarageRepo;
import com.example.demo.service.CarService;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class CarServiceUnitTest {

	@Autowired
	private CarService service;
	
	@MockBean
	private CarRepo repo;
	


	@Test
	void testGetById() {
		final Long Id = 1L;
		final Car Car = new Car(Id, "Audi", "4356");

		Mockito.when(this.repo.findById(Id)).thenReturn(Optional.of(Car));

		assertThat(this.service.getById(Id)).isEqualTo(Car);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}

	@Test
	void testgetAll() {
		final List<Car> Car = List.of(new Car("Audi", "4356"),
				new Car("SEAT", "NW9"));

		Mockito.when(this.repo.findAll()).thenReturn(Car);

		assertThat(this.service.getAll()).isEqualTo(Car);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
}
