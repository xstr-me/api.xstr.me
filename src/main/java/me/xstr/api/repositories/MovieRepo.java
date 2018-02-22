package me.xstr.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

	Movie findOneById(int id);
	List<Movie> findById(int id);
	List<Movie> findByOriginalTitle(String title);

}
