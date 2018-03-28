package me.xstr.api.batch.processors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.xstr.api.models.MediaType;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.models.imdb.ImdbRawMedia;
import me.xstr.api.services.ImdbRatingService;
import me.xstr.api.services.XstrMediaService;

@Component
public class XstrMediaItemProcessor implements ItemProcessor<ImdbRawMedia, ImdbRating> {

	private static final Logger log = LoggerFactory.getLogger(XstrMediaItemProcessor.class);

	@Autowired
	private ImdbRatingService imdbRatingService;

	@Autowired
	private XstrMediaService xstrMediaService;

	@Override
	public ImdbRating process(final ImdbRawMedia imdbrawMedia) throws Exception {
		ImdbMedia imdbMedia = new ImdbMedia(imdbrawMedia);
		//imdbMedia.setOriginalTitle("123" + System.currentTimeMillis());
		//imdbRatingService.saveImdbMedia(new ImdbMedia(555, MediaType.MOVIE,"cddfhgdghcd","cdfgdfqd",false,null,null,0,""));
		if(imdbMedia.getTitleType()==null){
			log.info("skipping unknown entry {} ImdbID exists", imdbrawMedia.getTconst());
			return null;
		}
		
		if (imdbRatingService.findOneByImdbId(imdbMedia.getImdbId()) != null) {
			log.info("skipping entry {} ImdbID exists", imdbrawMedia.getTconst());
			return null;
		}
		if (xstrMediaService.findByOriginalTitle(imdbMedia.getOriginalTitle()) != null) {
			log.info("skipping entry {} Title exists", imdbrawMedia.getTconst());
			return null;
		}
		log.info("*** adding entry {} to DataSource with Title {}", imdbrawMedia.getTconst(), imdbrawMedia.getOriginalTitle());
		return new ImdbRating(imdbMedia);
	}
}
