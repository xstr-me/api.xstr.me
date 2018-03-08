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
@DiscriminatorValue(MediaType.TVEPISODE)
public class TvEpisode extends XstrMedia {

	public TvEpisode(ImdbMedia imdbMedia) {
		super(imdbMedia);}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5465212157947595499L;
/*
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="xstrMedia")
	private ImdbRating imdbRating;
*/
}
