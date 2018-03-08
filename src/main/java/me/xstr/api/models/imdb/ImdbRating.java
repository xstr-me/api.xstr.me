package me.xstr.api.models.imdb;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

	public ImdbRating(int imdbId) {
		this.setImdbId(imdbId);
		this.setAverageRating(0);
		this.setNumVotes(0);
	}

	public ImdbRating(ImdbMedia imdbMedia, String type) {
		this.setImdbId(imdbMedia.getImdbId());
		this.setAverageRating(0);
		this.setNumVotes(0);
		switch (type) {
		case "movie":
		case "tvMovie":
		case "tvSpecial":
			this.xstrMedia = new Movie(imdbMedia);
			break;
		case "tvSeries":
		case "tvMiniSeries":
			this.xstrMedia = new TvShow(imdbMedia);
			break;
		case "short":
		case "tvShort":
			this.xstrMedia = new ShortMovie(imdbMedia);
			break;
		case "tvEpisode":
			this.xstrMedia = new TvEpisode(imdbMedia);
			break;
		default:
			this.xstrMedia = new XstrMedia(imdbMedia);
			break;
		}

	}

	@Id
	int id;

	protected int imdbId;

	protected float averageRating;
	protected int numVotes;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, optional = true)
	@JoinColumn(name = "xstrMedia")
	@MapsId
	private XstrMedia xstrMedia;

}
