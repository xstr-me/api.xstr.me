package me.xstr.api.services;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.xstr.api.models.Movie;
import me.xstr.api.models.XstrMedia;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;

public interface XstrMediaService {
	
	@Transactional(readOnly = true)
	XstrMedia getOne(int id);
	
	@Transactional(readOnly = true)
	List<XstrMedia> findAll();

	@Transactional(readOnly = true)
	XstrMedia findOneById(int id);

	@Transactional(readOnly = true)
	XstrMedia findOneByImdbRatingId(int id);
	
	@Transactional(readOnly = true)
	XstrMedia findByOriginalTitle(String title);
	
	@Transactional
	XstrMedia save(XstrMedia xstrMedia);
	
	@Transactional
	XstrMedia saveImdbMovie(ImdbMedia imdbMedia);

}
