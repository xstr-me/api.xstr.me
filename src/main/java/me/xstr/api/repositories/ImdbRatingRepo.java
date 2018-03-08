package me.xstr.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.xstr.api.models.imdb.ImdbRating;

@Repository
public interface ImdbRatingRepo extends JpaRepository<ImdbRating, Integer> {

	ImdbRating findOneByImdbId(int id);

}
