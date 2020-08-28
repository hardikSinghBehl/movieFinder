package com.hardik.movieFinder.service;

import org.springframework.stereotype.Service;

@Service
public class LinkGenerator {

	private String url = "http://www.omdbapi.com/?apikey=78000757&t=";

	public String generate(String title) {
		return url+title.trim().replace(" ", "_");
	}

}
