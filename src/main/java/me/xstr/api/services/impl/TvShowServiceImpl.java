package me.xstr.api.services.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.xstr.api.models.TvShow;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbTvShowRating;
import me.xstr.api.repositories.ImdbTvShowRatingRepo;
import me.xstr.api.repositories.TvShowRepo;
import me.xstr.api.services.TvShowService;

@Service
public class TvShowServiceImpl implements TvShowService {

	@Autowired
	private TvShowRepo tvShowRepo;

	@Autowired
	private ImdbTvShowRatingRepo imdbTvShowRatingRepo;

	@Override
	public List<TvShow> findAll() {
		return tvShowRepo.findAll();
	}

	@Override
	public TvShow findOneById(int id) {
		return tvShowRepo.findOneById(id);
	}

	@Override
	public TvShow getOne(int id) {
		return tvShowRepo.getOne(id);
	}

	@Override
	public List<TvShow> findByOriginalTitle(String title) {
		return Collections.emptyList();
	}

	@Override
	public TvShow findOneByImdbRatingId(int id) {
		return imdbTvShowRatingRepo.findOneByImdbId(id).getTvShow();
	}

	@Override
	public TvShow save(TvShow tvShow) {
		return tvShowRepo.save(tvShow);
	}

	@Override
	public TvShow saveImdbTvShow(ImdbMedia imdbMedia) {
		ImdbTvShowRating imdbTvShowRating = new ImdbTvShowRating(imdbMedia.getImdbId());
		TvShow tvShow = new TvShow();
		tvShow.setShortTitle(imdbMedia.getOriginalTitle());
		tvShow.setOriginalLanguage("en");
		imdbTvShowRating.setTvShow(tvShow);
		return imdbTvShowRatingRepo.save(imdbTvShowRating).getTvShow();
	}

}
