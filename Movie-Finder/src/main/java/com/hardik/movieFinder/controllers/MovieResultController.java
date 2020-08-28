package com.hardik.movieFinder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.movieFinder.service.MovieService;

@Controller
public class MovieResultController {
	
	private MovieService movieService;

	public MovieResultController() {
		super();
	}

	@Autowired
	public MovieResultController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}
	
	@PostMapping("/result")
	public String posting(@RequestParam("title") String title, Model model) {
		try {
			model.addAttribute("movie",movieService.getMovie(title));
		}catch(RuntimeException exception) {
			return "redirect:/?error";
		}
			return "result";
	}
	
}
