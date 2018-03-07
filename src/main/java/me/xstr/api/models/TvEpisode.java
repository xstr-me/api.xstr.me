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
import me.xstr.api.models.imdb.ImdbTvEpisodeRating;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue(MediaType.TVEPISODE)
public class TvEpisode extends XstrMedia {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5465212157947595499L;

	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="tvEpisode")
	private ImdbTvEpisodeRating imdbTvEpisodeRating;
}
