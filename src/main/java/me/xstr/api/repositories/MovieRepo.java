package me.xstr.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.domain.TmdbMovie;

@Repository
public interface MovieRepo extends CrudRepository<TmdbMovie, Integer> {

	TmdbMovie findOneById(long id);
	List<TmdbMovie> findById(long id);
	List<TmdbMovie> findByTitle(String title);

}
