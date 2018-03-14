package me.xstr.api.services;


import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;

public interface ImdbRatingService {
	@Transactional(readOnly = true)
	List<ImdbRating> findAll();

	@Transactional(readOnly = true)
	Optional<ImdbRating> findOneById(int id);
	
	@Transactional
	ImdbRating save(ImdbRating imdbRating);
	
	@Transactional
	ImdbRating saveImdbMedia(ImdbMedia imdbMedia);

	@Transactional(readOnly = true)
	ImdbRating findOneByImdbId(int imdbId);

}
