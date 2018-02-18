package me.xstr.api.services;


import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import me.xstr.api.domain.TmdbMovie;

public interface TmdbMovieService {
	@Transactional(readOnly = true)
	List<TmdbMovie> findAll();

	@Transactional(readOnly = true)
	TmdbMovie findOneById(Integer id);
	
	@Transactional(readOnly = true)
	List<TmdbMovie> findByTitle(String title);

}
