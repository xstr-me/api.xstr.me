package me.xstr.api.models;

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
import me.xstr.api.models.imdb.ImdbMovieRating;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Entity
@DiscriminatorValue(MediaType.MOVIE)
public class Movie extends XstrMedia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2217417306484271138L;
	
	public Movie() {
		super();
	}
	
	public Movie(ImdbMedia imdbMedia) {
		super();
		this.setShortTitle(imdbMedia.getOriginalTitle());
		this.setOriginalLanguage("en");
		this.setReleaseDate(imdbMedia.getStartYear());
		this.imdbMovieRating = new ImdbMovieRating(this.getId(),imdbMedia.getImdbId());
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "movie", optional = true)
	private ImdbMovieRating imdbMovieRating;
}
