Coverage: 64.1%

Hobby-Web-Application Project
This is my HWA project where I have created a full stack springboot for users to create cars and garages. The project allows users with the CRUD functions: Create, Read, Add, Update and Delete for the user.
This project consisted me of creating these tables in SQL and using Java on eclipse for backend coding. I also used postman to test my requests and carried out many testing methods including mockito and J Unit within my backend.
I have also created a front-end for this project where users can interact on the front end browser and data will be maniplulated to backend using fetch requests. This consisted me of using HTML, JAVA SCRIPT and CSS.

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

Prerequisites
What things you need to install the software and how to install them

• Version Control System: Git • Source Code Management: GitHub • Kanban Board: Jira • Database Management System: MySQL Server 5.7+ (local or GCP instance) • Back-End Programming Language: Java • Build Tool: Maven • Unit Testing: JUnit IDE = eclipse

Installing
Clone the link into your files and install it in your eclipse IDE.
Make sure you git clone it down and create your own branch to work on.
Once installed you can navigate through the methods and tables and input data and manipulate it accordingly A step by step series of examples that tell you how to get a development env running


Running the tests


Unit Tests
These test the functionality of individual methods for CRUD

Integration Tests
Many integration tests have been created for my application using Mockito. Mockito (or any other mocking tool) is a framework that you specifically use to efficiently write certain kind of tests. Here is a example.

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

	

	



	@Test
	void testGetAll() throws Exception {
		Garage jb = new Garage(1, "BMW PARK ROYAL", "NW10");
		String garagesJSON = this.mapper.writeValueAsString(List.of(jb));
		RequestBuilder request = get("/garage/getAll");

		ResultMatcher checkStatus = status().isAccepted();

		ResultMatcher checkBody = content().json(garagesJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}



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


And coding style tests
There are many coding style tests I have used coverage as JUnit test where you right click file and run covereage as JUnit. This gives a % of coverage example Coverage as JUNIT

Deployment
Run as a fatJAR file for deployment with maven on a live system and MySQL
localhost:9000 as api URL and localhost:3306

Built With
SpringBoot
Maven - Dependency Management
Versioning
We use SemVer for versioning.

Authors
Hamza Shah - Initial work - hamza12618
License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

Acknowledgments
Hat tip to anyone whose code was used
Inspiration
etc
