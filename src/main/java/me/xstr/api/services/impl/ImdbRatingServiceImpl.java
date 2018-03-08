package me.xstr.api.services.impl;

import java.util.Collections;
import java.util.List;

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
	public ImdbRating findOneById(int id) {
		return null;
	}

	@Override
	public ImdbRating save(ImdbRating imdbRating) {
		return imdbRatingRepo.save(imdbRating);
	}

	@Override
	public ImdbRating saveImdbMedia(ImdbMedia imdbMedia,String type) {
		return imdbRatingRepo.save(new ImdbRating(imdbMedia,type));
	}

}
