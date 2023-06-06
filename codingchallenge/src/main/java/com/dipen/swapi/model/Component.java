package com.dipen.swapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Component {
	
	private List<ChildObject> results;
	private String nextUrl;

	public List<ChildObject> getResults() {
		return results;
	}

	public void setResults(List<ChildObject> results) {
		this.results = results;
	}

	public String getNextUrl() {
		return nextUrl;
	}

	public void setNextUrl(String nextUrl) {
		this.nextUrl = nextUrl;
	}

	

}
