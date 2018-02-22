package me.xstr.api.services;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import me.xstr.api.models.Movie;

public interface MovieService {
	@Transactional(readOnly = true)
	List<Movie> findAll();

	@Transactional(readOnly = true)
	Movie findOneById(int id);
	
	@Transactional(readOnly = true)
	List<Movie> findByOriginalTitle(String title);

}
