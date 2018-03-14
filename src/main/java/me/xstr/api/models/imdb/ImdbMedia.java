package me.xstr.api.models.imdb;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.util.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.xstr.api.models.MediaType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImdbMedia {

	public ImdbMedia(ImdbRawMedia imdbRawMedia) {
		this.setTitleType(MediaType.getBySymbole(imdbRawMedia.getTitleType()));
		this.setImdbId(Integer.parseInt(imdbRawMedia.getTconst().substring(2)));

		String shortTiltle = imdbRawMedia.getOriginalTitle();
		//if (shortTiltle.length() > 25)
		//	shortTiltle = imdbRawMedia.getOriginalTitle().substring(0, 21) + "...";
		//this.setOriginalTitle(shortTiltle);
		this.setOriginalTitle(imdbRawMedia.getOriginalTitle());

		shortTiltle = imdbRawMedia.getPrimaryTitle();
		if (shortTiltle.length() > 25)
			shortTiltle = imdbRawMedia.getPrimaryTitle().substring(0, 21) + "...";

		if (shortTiltle.equals(this.getOriginalTitle()))
			shortTiltle = null;
		this.setPrimaryTitle(shortTiltle);

		shortTiltle = imdbRawMedia.getGenres();
		if (!imdbRawMedia.getGenres().equals("\\N")) {
			if (shortTiltle.length() > 25)
				shortTiltle = imdbRawMedia.getGenres().substring(0, 21) + "...";
			this.setGenres(shortTiltle);
		}

		int startYear = 0;
		if (!imdbRawMedia.getStartYear().equals("\\N")) {
			startYear = Integer.parseInt(imdbRawMedia.getStartYear());
		}
		Date startYearDate = null;
		if (startYear != 0) {
			startYearDate = this.getDate(startYear);
		}

		this.setStartYear(startYearDate);

		int endYear = 0;
		if (!imdbRawMedia.getEndYear().equals("\\N")) {
			endYear = Integer.parseInt(imdbRawMedia.getEndYear());
		}
		Date endYearDate = null;
		if (endYear != 0) {
			endYearDate = this.getDate(endYear);
		}

		this.setEndYear(endYearDate);

		int runtime = 0;
		if (!imdbRawMedia.getRuntimeMinutes().equals("\\N")) {
			runtime = Integer.parseInt(imdbRawMedia.getRuntimeMinutes());
		}
		if (runtime != 0)
			this.setRuntimeMinutes(runtime);

		this.setAdult(imdbRawMedia.getIsAdult().equals("1"));
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

	@Id
	private int imdbId;
	//@Column(length = 15)
	private MediaType titleType;
	@Column(length = 25)
	private String primaryTitle;
	@Column(length = 25)
	private String originalTitle;
	private boolean isAdult;
	private Date startYear;
	private Date endYear;
	private int runtimeMinutes;
	@Column(length = 25)
	private String genres;

}
