package me.xstr.api.batch.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;

@Component
public class XstrMediaItemProcessor implements ItemProcessor<ImdbMedia,ImdbRating> {

	private static final Logger log = LoggerFactory.getLogger(XstrMediaItemProcessor.class);

	@Override
	public ImdbRating process(final ImdbMedia imdbMedia) throws Exception {
		log.info("#####  processing {} with id {}", imdbMedia.getTitleType(), imdbMedia.getImdbId());
		return new ImdbRating(imdbMedia, imdbMedia.getTitleType());
	}
}
