package com.dipen.swapi.controlller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dipen.swapi.service.ApiService;

/*
 * author : dipen
 * 
 * This class contains set of APIs requested in assessment - getStartshipsofLuke, 
 * getSpicesOfFirstEpisode, getTotalPopulationOfAllPlanets
 * 
 */

@RestController
@RequestMapping(value = "/api")
public class ApiController {

	@Autowired
	ApiService apiservice;

	@GetMapping(value = "/luke-starships")
	public ResponseEntity<List<String>> getStartshipsofLuke() {
		List<String> starships = apiservice.getStartshipsofLuke("Luke Skywalker");
		if (starships == null) {
			return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<String>>(starships, HttpStatus.OK);
	}

	@GetMapping(value = "/ep_1_species")
	public ResponseEntity<Set<String>> getSpicesOfFirstEpisode() {
		Set<String> classification = apiservice.getSpicesOfFirstEpisode(1);
		if (classification == null) {
			return new ResponseEntity<Set<String>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Set<String>>(classification, HttpStatus.OK);
	}

	@GetMapping(value = "/population-of-planets")
	public ResponseEntity<Long> getTotalPopulationOfAllPlanets() {
		Long population = apiservice.getTotalPopulationOfAllPlanets();
		return new ResponseEntity<Long>(population, HttpStatus.OK);
	}
}
