package me.xstr.api.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.xstr.api.models.Movie;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbMovieRating;
import me.xstr.api.repositories.ImdbMovieRatingRepo;
import me.xstr.api.repositories.MovieRepo;
import me.xstr.api.services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepo movieRepo;

	@Autowired
	private ImdbMovieRatingRepo imdbMovieRatingRepo;

	@Override
	public List<Movie> findAll() {
		return movieRepo.findAll();
	}

	@Override
	public Movie findOneById(int id) {
		return movieRepo.findOneById(id);
	}

	@Override
	public Movie getOne(int id) {
		return movieRepo.getOne(id);
	}

	@Override
	public java.util.List<Movie> findByOriginalTitle(String title) {
		return Collections.emptyList();
	}

	@Override
	public Movie findOneByImdbRatingId(int id) {
		return imdbMovieRatingRepo.findOneByImdbId(id).getMovie();
	}

	@Override
	public Movie save(Movie movie) {
		return movieRepo.save(movie);
	}

	@Override
	public Movie saveImdbMovie(ImdbMedia imdbMedia) {
		//ImdbMovieRating imdbMovieRating = new ImdbMovieRating(imdbMedia.getImdbId());
		//Movie movie = new Movie();
		//movie.setShortTitle(imdbMedia.getOriginalTitle());
		//movie.setOriginalLanguage("en");
		//imdbMovieRating.setMovie(movie);
		//return imdbMovieRatingRepo.save(imdbMovieRating).getMovie();
		return movieRepo.save(new Movie(imdbMedia));
	}

}
