package me.xstr.api.models;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.xstr.api.models.imdb.ImdbMedia;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(MediaType.TVSHOW)
public class TvShow extends XstrMedia {
	public TvShow(ImdbMedia imdbMedia) {
		super(imdbMedia);
		this.endDate = imdbMedia.getEndYear();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905160265686354694L;
	private Date endDate;
/*
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy="xstrMedia",optional= true)
	protected ImdbRating imdbRating;
*/
}
