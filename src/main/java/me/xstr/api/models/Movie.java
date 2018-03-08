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
@DiscriminatorValue(MediaType.MOVIE)
public class Movie extends XstrMedia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2217417306484271138L;
	
	public Movie(ImdbMedia imdbMedia) {
		super(imdbMedia);
	}
}
