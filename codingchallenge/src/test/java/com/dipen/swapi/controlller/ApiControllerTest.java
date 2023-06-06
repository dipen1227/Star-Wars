package com.dipen.swapi.controlller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiControllerTest {
	ObjectMapper om = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("statusCode200WhenGetStartshipsofLuke")
	void statusCode200WhenGetStartshipsofLuke() throws Exception {
		mockMvc.perform(get("/api/luke-starships")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("statusCode200WhenGetSpicesOfFirstEpisode")
	void statusCode200WhenGetSpicesOfFirstEpisode() throws Exception {
		mockMvc.perform(get("/api/ep_1_species")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("statusCode200WhenGetTotalPopulationOfAllPlanets")
	void statusCode200WhenGetTotalPopulationOfAllPlanets() throws Exception {
		mockMvc.perform(get("/api/population-of-planets")).andDo(print()).andExpect(status().isOk());
	}

}
