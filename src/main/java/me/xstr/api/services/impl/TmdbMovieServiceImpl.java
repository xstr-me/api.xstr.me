package me.xstr.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.xstr.api.domain.TmdbMovie;
import me.xstr.api.repositories.MovieRepo;
import me.xstr.api.services.TmdbMovieService;

@Service
public class TmdbMovieServiceImpl implements TmdbMovieService {
	
	private MovieRepo movieRepo;

	@Override
	public List<TmdbMovie> findAll() {
		return (List<TmdbMovie>) movieRepo.findAll();
	}

	@Override
	public TmdbMovie findOneById(Integer id) {
		return movieRepo.findOneById(id);
	}

	@Override
	public java.util.List<TmdbMovie> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	public void setMovieRepo(MovieRepo movieRepo) {
		this.movieRepo = movieRepo;
	}

}
