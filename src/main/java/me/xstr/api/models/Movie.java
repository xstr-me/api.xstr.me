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

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class Movie extends XstrMedia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2217417306484271138L;
	protected String shortTitle;
	protected Date releaseDate;
	protected String originalLanguage;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "movie", optional = true)
	private ImdbMovieRating imdbMovieRating;
}
