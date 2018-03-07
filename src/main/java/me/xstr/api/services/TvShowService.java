package me.xstr.api.services;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.xstr.api.models.Movie;
import me.xstr.api.models.TvShow;
import me.xstr.api.models.imdb.ImdbMedia;

public interface TvShowService {
	
	@Transactional(readOnly = true)
	TvShow getOne(int id);
	
	@Transactional(readOnly = true)
	List<TvShow> findAll();

	@Transactional(readOnly = true)
	TvShow findOneById(int id);

	@Transactional(readOnly = true)
	TvShow findOneByImdbRatingId(int id);
	
	@Transactional(readOnly = true)
	List<TvShow> findByOriginalTitle(String title);
	
	@Transactional
	TvShow save(TvShow tvShow);
	
	@Transactional
	TvShow saveImdbTvShow(ImdbMedia imdbMedia);

}
