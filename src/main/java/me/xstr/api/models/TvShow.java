package me.xstr.api.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbTvShowRating;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(MediaType.TVSHOW)
public class TvShow extends XstrMedia {
	public TvShow(ImdbMedia imdbMedia) {
		super();
		super.setShortTitle(imdbMedia.getOriginalTitle());
		super.setOriginalLanguage("en");
		super.setReleaseDate(imdbMedia.getStartYear());
		this.endDate = imdbMedia.getEndYear();
		this.imdbTvShowRating = new ImdbTvShowRating(imdbMedia.getImdbId());
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905160265686354694L;
	private Date endDate;
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="tvShow",optional= true)
	protected ImdbTvShowRating imdbTvShowRating;
}
