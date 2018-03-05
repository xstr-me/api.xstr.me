package me.xstr.api.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("2")
public class TvShow extends XstrMedia {
	private Date endDate;
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE, mappedBy="tvShow")
	protected ImdbTvShowRating imdbTvShowRating;
}
