package me.xstr.api.models.imdb;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.xstr.api.models.Movie;
import me.xstr.api.models.XstrMedia;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name="mediatype",
discriminatorType=DiscriminatorType.STRING)
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Table(indexes = { @Index(columnList = "imdbId") })
public class ImdbRating implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3957215591730354433L;
	public ImdbRating(int id,int imdbId) {
		this.setId(id);
		this.setImdbId(imdbId);
		this.setAverageRating(0);
		this.setNumVotes(0);
	}

    @Id
    protected int id;
    
    protected int imdbId;
    
    protected float averageRating;
    protected int numVotes;
/*	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="xstrMedia",updatable=false,insertable=false)
	private XstrMedia xstrMedia;
*/
    

}
