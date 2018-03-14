package me.xstr.api.models;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRating;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(
name="mediatype",
discriminatorType=DiscriminatorType.STRING,length=2)
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class XstrMedia implements Serializable {
	
	public XstrMedia(ImdbMedia imdbMedia) {
		this.setOriginalTitle(new XstrTitle(imdbMedia.getOriginalTitle()));//
		this.setOriginalLanguage("en");
		this.setReleaseDate(imdbMedia.getStartYear());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1136056158965931566L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    protected int id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval=true)
	protected XstrTitle originalTitle;

	@OneToMany
	protected List<XstrAlternativeTitle> alternativeTitles;
	protected Date releaseDate;
	@Column(length=2)
	protected String originalLanguage;
    
    @Version
    protected int version;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "xstrMedia", optional = true)
	protected ImdbRating imdbRating;

}
