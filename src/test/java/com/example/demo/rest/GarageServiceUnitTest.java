package com.example.demo.rest;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.example.demo.domain.Garage;
import com.example.demo.repo.GarageRepo;
import com.example.demo.service.GarageService;
//@RunWith(MockitoJUnitRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class GarageServiceUnitTest {
	
	@Autowired
	private GarageService service;
	
	@MockBean
	private GarageRepo repo;
	


	@Test
	void testGetById() {
		final Long Id = 1L;
		final Garage Garage = new Garage(Id, "BMW PARK ROYAL", "NW10");

		Mockito.when(this.repo.findById(Id)).thenReturn(Optional.of(Garage));

		assertThat(this.service.getById(Id)).isEqualTo(Garage);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}

	@Test
	void testgetAll() {
		final List<Garage> Garage = List.of(new Garage("BMW PARK ROYAL", "NW10"),
				new Garage("SEAT", "NW9"));

		Mockito.when(this.repo.findAll()).thenReturn(Garage);

		assertThat(this.service.getAll()).isEqualTo(Garage);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
//	@Test
//	void testUpdateGarage() {
//		final Long id = 1L;
//		Garage Garage = new Garage("BMW PARK ROYAL", "NW10");
//		Optional<Garage> optionalGarage = Optional.of(Garage);
//		
//		Garage newGarage = new Garage("BMW PARK ROYAL", "NW4");
//		
//		Mockito.when(this.repo.findById(Garage.getById())).thenReturn(optionalGarage);
//		Mockito.when(this.repo.save(newGarage)).thenReturn(newGarage);
//		
//		assertThat(this.service.updateGarage(newGarage, Garage.getId())).isEqualTo(newGarage);
//		
//		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
//		Mockito.verify(this.repo, Mockito.times(1)).save(newGarage);
//	}
	
//	@Test
//	void testCreate() {
//		Garage newGarage = new Garage( "BMW PARK ROYAL", "NW10");
//		Garage savedGarage = new Garage(1, "BMW PARK ROYAL", "NW10");
//
//		Mockito.when(this.repo.save(newGarage)).thenReturn(savedGarage);
//
//		assertThat(this.service.create(newGarage)).isEqualTo(savedGarage);
//
//		Mockito.verify(this.repo, Mockito.times(1)).save(newGarage);
//	}



		
		
	    
	}

//
//}
//
//
//	
//	@InjectMocks
//	private GarageService service;
//	
//	@Mock
//	private GarageRepo repo;
//	
//	@Test
//	public void createTest() {
//        Garage input = new Garage("BMW PARK ROYAL", "NW10");
//		Garage output = new Garage(1L, "BMW PARK ROYAL", "NW10");
//		
//		Mockito.when(this.repo.save(input)).thenReturn(output);
//		
//		assertEquals(output, this.service.create(input));
//		
//		Mockito.verify(this.repo, Mockito.times(1)).save(input);
//	}
//	
//	@Test
//	public void getAllTest() {
//		List<Garage> output = new ArrayList<>();
//		output.add(new Garage("BMW PARK ROYAL", "NW10"));
//		
//		Mockito.when(this.repo.findAll()).thenReturn(output);
//		
//		assertEquals(output, this.service.getAll());
//		
//		Mockito.verify(this.repo, Mockito.times(1)).findAll();
//	}