package me.xstr.api.models.imdb;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.xstr.api.models.MediaType;
import me.xstr.api.models.Movie;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Entity
@DiscriminatorValue(MediaType.MOVIE)
public class ImdbMovieRating extends ImdbRating {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6410373365600543099L;

	public ImdbMovieRating(int id,int imdbId){
		super(id,imdbId);
	}
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,optional=false)
	@MapsId
	@JoinColumn(name="xstrMedia",updatable=true,insertable=true)
	private Movie movie;
}
