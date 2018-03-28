package me.xstr.api.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.xstr.api.models.XstrMedia;
import me.xstr.api.models.XstrTitle;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.repositories.XstrMediaRepo;
import me.xstr.api.services.XstrMediaService;

@Service
public class XstrMediaServiceImpl implements XstrMediaService {

	@Autowired
	private XstrMediaRepo xstrMediaRepo;

	@Override
	public List<XstrMedia> findAll() {
		return xstrMediaRepo.findAll();
	}

	@Override
	public XstrMedia findOneById(int id) {
		return xstrMediaRepo.findOneById(id);
	}

	@Override
	public XstrMedia getOne(int id) {
		return xstrMediaRepo.getOne(id);
	}

	@Override
	public XstrMedia findByOriginalTitle(String title) {
		return xstrMediaRepo.findByOriginalTitleUuid(UUID.nameUUIDFromBytes(("xstr.me-" + title + "-uuid").getBytes()));
	}

	@Override
	public XstrMedia findOneByImdbRatingId(int id) {
		return null; // imdbMovieRatingRepo.findOneByImdbId(id).getMovie();
	}

	@Override
	public XstrMedia save(XstrMedia xstrMedia) {
		return xstrMediaRepo.save(xstrMedia);
	}

	@Override
	public XstrMedia saveImdbMovie(ImdbMedia imdbMedia) {
		return xstrMediaRepo.save(new XstrMedia(imdbMedia));
	}

}
