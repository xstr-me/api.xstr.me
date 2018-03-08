package me.xstr.api.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.xstr.api.models.imdb.ImdbMedia;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
@DiscriminatorValue(MediaType.SHORT)
public class ShortMovie extends XstrMedia {

	public ShortMovie(ImdbMedia imdbMedia) {
		super(imdbMedia);}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6924138917935553012L;
/*
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "xstrMedia", optional = true)
	ImdbRating imdbRating;
	*/
	}
