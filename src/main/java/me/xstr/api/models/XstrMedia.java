package me.xstr.api.models;


import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.xstr.api.models.imdb.ImdbMovieRating;
import me.xstr.api.models.imdb.ImdbRating;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(
name="mediatype",
discriminatorType=DiscriminatorType.STRING)
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class XstrMedia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1136056158965931566L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    protected int id;

	protected String shortTitle;
	protected Date releaseDate;
	protected String originalLanguage;
    
    @Version
    protected int version;

}
