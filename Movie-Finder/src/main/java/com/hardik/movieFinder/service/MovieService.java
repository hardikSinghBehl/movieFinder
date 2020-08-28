package com.hardik.movieFinder.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
	
	private RestTemplate restTemplate;
	
	private LinkGenerator linkGenerator;

	public MovieService() {
		super();
	}

	@Autowired
	public MovieService(LinkGenerator linkGenerator,RestTemplate restTemplate ) {
		super();
		this.linkGenerator = linkGenerator;
		this.restTemplate  = restTemplate;
	}
	
	public Object getMovie(String title) {
		Object movie = restTemplate.getForObject(linkGenerator.generate(title), Object.class);
		if (((HashMap<String, Map>)movie).containsValue("False"))
			throw new RuntimeException();
		return movie;
	}
	
}
