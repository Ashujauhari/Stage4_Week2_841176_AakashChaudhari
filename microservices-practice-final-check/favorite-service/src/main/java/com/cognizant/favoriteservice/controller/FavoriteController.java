package com.cognizant.favoriteservice.controller;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.favoriteservice.exception.MovieNotFoundException;
import com.cognizant.favoriteservice.model.Movie;
import com.cognizant.favoriteservice.service.FavoriteServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/favorites")
@Slf4j
public class FavoriteController {

	@Autowired
	private FavoriteServiceImpl favoriteServiceImpl;

	// Adds given Movie to given users favorite.
	@PostMapping("/{userId}/{movieId}")
	public void addFavoriteMovie(@PathVariable("userId") int userId, @PathVariable("movieId") int movieId)
			throws MovieNotFoundException {
		log.info("START");
		favoriteServiceImpl.addFavoriteMovie(userId, movieId);
		log.info("END");
	}

	// fetch all the favorite movies of existing users
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON)
	public ArrayList<Movie> getAllFavoriteMovies(@PathVariable("userId") int userId) {
		log.info("START");
		return favoriteServiceImpl.getAllFavoriteMovies(userId);
	}

	// Delete movie from users favorite
	@DeleteMapping("/{userId}/{movieId}")
	public void deleteFavoriteMovie(@PathVariable("userId") int userId, @PathVariable("movieId") int movieId) {
		log.debug("START");
		favoriteServiceImpl.deleteFavoriteMovie(userId, movieId);
		log.debug("END");
	}
}
