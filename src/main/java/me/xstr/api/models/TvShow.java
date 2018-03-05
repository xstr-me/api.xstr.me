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

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("2")
public class TvShow extends XstrMedia {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905160265686354694L;
	private Date endDate;
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE, mappedBy="tvShow")
	protected ImdbTvShowRating imdbTvShowRating;
}
