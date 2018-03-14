package me.xstr.api.services.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.repositories.ImdbRatingRepo;
import me.xstr.api.services.ImdbRatingService;

@Service
public class ImdbRatingServiceImpl implements ImdbRatingService {
	
	@Autowired
	private ImdbRatingRepo imdbRatingRepo;

	@Override
	public List<ImdbRating> findAll() {
		return Collections.emptyList();
	}

	@Override
	public Optional<ImdbRating> findOneById(int id) {
		return imdbRatingRepo.findById(id);
	}

	@Override
	public ImdbRating save(ImdbRating imdbRating) {
		return imdbRatingRepo.save(imdbRating);
	}

	@Override
	public ImdbRating saveImdbMedia(ImdbMedia imdbMedia) {
		return imdbRatingRepo.save(new ImdbRating(imdbMedia));
	}

	@Override
	public ImdbRating findOneByImdbId(int imdbId) {
		return imdbRatingRepo.findOneByImdbId(imdbId);
	}

}
