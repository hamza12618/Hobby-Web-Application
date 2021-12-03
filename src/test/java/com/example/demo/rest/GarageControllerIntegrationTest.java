package com.example.demo.rest;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.Garage;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // loads context and boots up on different port
@AutoConfigureMockMvc // tells Spring to setup the mockmvc object
@ActiveProfiles("test") // sets the active profile to 'test'
//runs the sql files before each test method
@Sql(scripts = { "classpath:garage-schema.sql",
		"classpath:garage-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class GarageControllerIntegrationTest {

	@Autowired // tells spring to inject in the mockmvc object
	private MockMvc mvc; // library that performs the requests

	@Autowired
	private ObjectMapper mapper; // the actual object Spring uses to convert Java <-> JSON

	@Test
	void testCreate() throws Exception {
		// body, method, content-type, url
		Garage me = new Garage("BMW PARK ROYAL", "NW10");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = post("/garage/create").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isCreated(); // matcher that we will use to test the response

		Garage meSaved = new Garage(2, "BMW PARK ROYAL", "NW10");
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	

	

//	@Test
//	void testgetByCarId() throws Exception {
//		Car jb = new Car(1, "BMW", "2345");
//		String jbAsJSON = this.mapper.writeValueAsString(jb);
//		RequestBuilder request = get("/car/getByCarId/1");
//
//		ResultMatcher checkStatus = status().isOk();
//
//		ResultMatcher checkBody = content().json(jbAsJSON);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//	}

	@Test
	void testGetAll() throws Exception {
		Garage jb = new Garage(1, "BMW PARK ROYAL", "NW10");
		String garagesJSON = this.mapper.writeValueAsString(List.of(jb));
		RequestBuilder request = get("/garage/getAll");

		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(garagesJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

//	@Test
//	void testGetByUsername() throws Exception {
//		User jb = new User(1, "jordan", "benbelaid", "jbizzle");
//		String jbAsJSON = this.mapper.writeValueAsString(jb);
//		RequestBuilder request = get("/user/getByUsername/" + jb.getUsername());
//
//		ResultMatcher checkStatus = status().isOk();
//
//		ResultMatcher checkBody = content().json(jbAsJSON);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//	}

	@Test
	void testUpdate() throws Exception {
		Garage me = new Garage("SEAT PARK ROYAL", "NW3");
		String meAsJSON = this.mapper.writeValueAsString(me);
		RequestBuilder request = put("/garage/update/1").contentType(MediaType.APPLICATION_JSON).content(meAsJSON);

		ResultMatcher checkStatus = status().isAccepted(); // matcher that we will use to test the response

		Garage meSaved = new Garage(1, "SEAT PARK ROYAL", "NW3");
		String meSavedAsJSON = this.mapper.writeValueAsString(meSaved);

		ResultMatcher checkBody = content().json(meSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/garage/delete/1")).andExpect(status().isNoContent());
	}


}


