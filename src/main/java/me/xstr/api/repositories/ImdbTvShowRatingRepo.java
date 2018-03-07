package me.xstr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.imdb.ImdbMovieRating;
import me.xstr.api.models.imdb.ImdbTvShowRating;

@Repository
public interface ImdbTvShowRatingRepo extends JpaRepository<ImdbTvShowRating, Integer> {

	ImdbTvShowRating findOneByImdbId(int id);

}
