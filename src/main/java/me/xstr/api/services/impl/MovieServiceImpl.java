package me.xstr.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.xstr.api.models.Movie;
import me.xstr.api.repositories.MovieRepo;
import me.xstr.api.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	private MovieRepo movieRepo;

	@Override
	public List<Movie> findAll() {
		return (List<Movie>) movieRepo.findAll();
	}

	@Override
	public Movie findOneById(int id) {
		return movieRepo.findOneById(id);
	}

	@Override
	public java.util.List<Movie> findByOriginalTitle(String title) {
		return null;
	}
	
	@Autowired
	public void setMovieRepo(MovieRepo movieRepo) {
		this.movieRepo = movieRepo;
	}

}
