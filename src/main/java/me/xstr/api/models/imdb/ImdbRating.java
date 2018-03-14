package me.xstr.api.models.imdb;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.xstr.api.batch.processors.ImdbMediaItemProcessor;
import me.xstr.api.models.MediaType;
import me.xstr.api.models.Movie;
import me.xstr.api.models.ShortMovie;
import me.xstr.api.models.TvEpisode;
import me.xstr.api.models.TvShow;
import me.xstr.api.models.XstrMedia;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
 * @DiscriminatorColumn( name="mediatype",
 * discriminatorType=DiscriminatorType.STRING)
 */
// @JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class,
// property="@id")
@Table(indexes = { @Index(columnList = "imdbId") })
public class ImdbRating implements Serializable {

	private static final long serialVersionUID = 3957215591730354433L;
	private static final Logger log = LoggerFactory.getLogger(ImdbRating.class);

	public ImdbRating(int imdbId) {
		this.setImdbId(imdbId);
		this.setAverageRating(0);
		this.setNumVotes(0);
	}

	public ImdbRating(ImdbMedia imdbMedia) {
		log.info("#####  processing {} with id {} Title = {}", imdbMedia.getTitleType(), imdbMedia.getImdbId(), imdbMedia.getOriginalTitle());
		this.setImdbId(imdbMedia.getImdbId());
		this.setAverageRating(0);
		this.setNumVotes(0);
	    this.xstrMedia= imdbMedia.getTitleType().getXstrMedia(imdbMedia);

	}

	@Id
	int id;

	@Column(unique=true)
	protected int imdbId;

	protected float averageRating;
	protected int numVotes;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "xstrMedia")
	@MapsId
	private XstrMedia xstrMedia;

}
