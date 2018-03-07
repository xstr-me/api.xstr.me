package me.xstr.api.batch.processors;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import me.xstr.api.models.MediaType;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRawMedia;

@Component
public class ImdbMediaItemProcessor implements ItemProcessor<ImdbRawMedia, ImdbMedia> {

	private static final Logger log = LoggerFactory.getLogger(AnidbTitlesItemProcessor.class);

	@Override
	public ImdbMedia process(final ImdbRawMedia imdbRawMedia) throws Exception {

		final ImdbMedia transformedImdbMedia = new ImdbMedia();
		transformedImdbMedia.setTitleType(MediaType.MOVIE);
		transformedImdbMedia.setImdbId(Integer.parseInt(imdbRawMedia.getTconst().substring(2)));

		String shortTiltle = imdbRawMedia.getOriginalTitle();
		if (shortTiltle.length() > 25)
			shortTiltle = imdbRawMedia.getOriginalTitle().substring(0, 21) + "...";
		transformedImdbMedia.setOriginalTitle(shortTiltle);

		shortTiltle = imdbRawMedia.getPrimaryTitle();
		if (shortTiltle.length() > 25)
			shortTiltle = imdbRawMedia.getPrimaryTitle().substring(0, 21) + "...";

		if (shortTiltle.equals(transformedImdbMedia.getOriginalTitle()))
			shortTiltle = null;
		transformedImdbMedia.setPrimaryTitle(shortTiltle);

		shortTiltle = imdbRawMedia.getGenres();
		if (!imdbRawMedia.getGenres().equals("\\N")) {
			if (shortTiltle.length() > 25)
				shortTiltle = imdbRawMedia.getGenres().substring(0, 21) + "...";
			transformedImdbMedia.setGenres(shortTiltle);
		}

		int startYear = 0;
		if (!imdbRawMedia.getStartYear().equals("\\N")) {
			startYear = Integer.parseInt(imdbRawMedia.getStartYear());
		}
		Date startYearDate = null;
		if (startYear != 0) {
			startYearDate = this.getDate(startYear);
		}

		transformedImdbMedia.setStartYear(startYearDate);

		int endYear = 0;
		if (!imdbRawMedia.getEndYear().equals("\\N")) {
			endYear = Integer.parseInt(imdbRawMedia.getEndYear());
		}
		Date endYearDate = null;
		if (endYear != 0) {
			endYearDate = this.getDate(endYear);
		}

		transformedImdbMedia.setEndYear(endYearDate);

		int runtime = 0;
		if (!imdbRawMedia.getRuntimeMinutes().equals("\\N")) {
			runtime = Integer.parseInt(imdbRawMedia.getRuntimeMinutes());
		}
		if (runtime != 0)
			transformedImdbMedia.setRuntimeMinutes(runtime);

		transformedImdbMedia.setAdult(imdbRawMedia.getIsAdult().equals("1"));

		log.info("Converting ({}) into ({})", imdbRawMedia, transformedImdbMedia);

		return transformedImdbMedia;
	}

	public Date getDate(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
