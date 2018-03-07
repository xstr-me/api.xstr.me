package me.xstr.api.batch.processors;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import me.xstr.api.models.MediaType;
import me.xstr.api.models.Movie;
import me.xstr.api.models.TvShow;
import me.xstr.api.models.XstrMedia;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRawMedia;

@Component
public class XstrMediaItemProcessor implements ItemProcessor<ImdbMedia,Movie> {

	private static final Logger log = LoggerFactory.getLogger(XstrMediaItemProcessor.class);

	@Override
	public Movie process(final ImdbMedia imdbMedia) throws Exception {
		switch(imdbMedia.getTitleType()) {
		case "movie": return new Movie(imdbMedia);
		// case "tvSeries": return new TvShow(imdbMedia);
		}
		return null;
		}
}
