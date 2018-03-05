package me.xstr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.ImdbMovieRating;
import me.xstr.api.models.ImdbRating;

@Repository
public interface ImdbMovieRatingRepo extends JpaRepository<ImdbMovieRating, Integer> {

	ImdbMovieRating findOneByImdbId(int id);

}
