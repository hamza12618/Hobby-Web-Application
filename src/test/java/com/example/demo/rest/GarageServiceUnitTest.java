//package com.example.demo.rest;
//
//package com.qa.springboottesting.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.example.demo.domain.Garage;
//import com.example.demo.repo.GarageRepo;
//
//@RunWith(MockitoJUnitRunner.class)
//public class GarageServiceUnitTest {
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