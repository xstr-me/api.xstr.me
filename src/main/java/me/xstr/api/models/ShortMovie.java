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
import me.xstr.api.models.imdb.ImdbMovieRating;
import me.xstr.api.models.imdb.ImdbShortMovieRating;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue(MediaType.SHORT)
public class ShortMovie extends XstrMedia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6924138917935553012L;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "shortMovie", optional = true)
	ImdbShortMovieRating imdbShortMovieRating;
	}
