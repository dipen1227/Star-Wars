package com.dipen.swapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dipen.swapi.model.ChildObject;
import com.dipen.swapi.model.Component;
import com.dipen.swapi.model.Species;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

/*
 * author : dipen
 * 
 * The APIService class contains swapi APIs consumption and call multiple APIs for the desired output.
 * 
 */

@Slf4j
@Service
public class ApiService {
	
	private static final Logger log = LoggerFactory.getLogger(ApiService.class);

	@Autowired 
	RestTemplate restTemplate ;

	private static String baseApi = "https://swapi.dev/api/";

	//get all starships of Luke Skywalker
	public List<String> getStartshipsofLuke(String name) {
		List<String> starships = new ArrayList();
		try {

			Component component = restTemplate
					.exchange(baseApi + "/people", HttpMethod.GET, getEntity(), Component.class).getBody();

			List<ChildObject> results = component.getResults();
			for (ChildObject co : results) {
				if (co.getName().contentEquals(name)) {
					List<String> starshipUrls = co.getStarships();
					ChildObject childObject;
					for (String url : starshipUrls) {
						childObject = restTemplate.exchange(url, HttpMethod.GET, getEntity(), ChildObject.class)
								.getBody();
						starships.add(childObject.getName());
					}
				}
			}

		} catch (Exception e) {
			log.debug("Exception in getStartshipsofLuke ", e);

		}
		return starships;
	}

	//get all unique Species of 1st Episode
	
	public Set<String> getSpicesOfFirstEpisode(int episode) {
		Set<String> species = new HashSet();

		Component component = restTemplate.exchange(baseApi + "/films", HttpMethod.GET, getEntity(), Component.class)
				.getBody();

		List<ChildObject> results = component.getResults();
		for (ChildObject co : results) {
			if (co.getEpisodeId() == episode) {
				List<String> specieUrls = co.getSpecies();
				for (String url : specieUrls) {
					Species s = restTemplate.exchange(url, HttpMethod.GET, getEntity(), Species.class).getBody();
					species.add(s.getClassification());
				}
			}
		}

		return species;
	}

	//get population of All planets
	public Long getTotalPopulationOfAllPlanets() {
		Component component = null;
		Long totalPopulation = 0L;
		String url = baseApi + "planets";
		do {
			component = restTemplate.exchange(url, HttpMethod.GET, getEntity(), Component.class).getBody();
			List<ChildObject> childObjects = component.getResults();
			for (ChildObject co : childObjects) {
				try {
					totalPopulation += Long.parseLong(co.getPopulation());
				} catch (Exception e) {
					log.debug("exception while calulation total polulation ", e);

				}
			}
			url = component.getNextUrl();
		} while (component.getNextUrl() != null);

		return totalPopulation;
	}

	private HttpEntity<String> getEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}

}