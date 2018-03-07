package me.xstr.api.models.imdb;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.xstr.api.models.MediaType;
import me.xstr.api.models.ShortMovie;
import me.xstr.api.models.TvEpisode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(MediaType.TVEPISODE)
public class ImdbTvEpisodeRating extends ImdbRating {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4803085853226321244L;

	public ImdbTvEpisodeRating(int id){
		//super(id);
	}
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="xstrMedia")
    private TvEpisode tvEpisode;
}
