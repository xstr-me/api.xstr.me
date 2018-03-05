package me.xstr.api.services;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.xstr.api.models.ImdbMedia;
import me.xstr.api.models.ImdbMovieRating;
import me.xstr.api.models.Movie;

public interface MovieService {
	
	@Transactional(readOnly = true)
	Movie getOne(int id);
	
	@Transactional(readOnly = true)
	List<Movie> findAll();

	@Transactional(readOnly = true)
	Movie findOneById(int id);

	@Transactional(readOnly = true)
	Movie findOneByImdbRatingId(int id);
	
	@Transactional(readOnly = true)
	List<Movie> findByOriginalTitle(String title);
	
	@Transactional
	Movie save(Movie movie);
	
	@Transactional
	Movie saveImdbMovie(ImdbMedia imdbMedia);

}
