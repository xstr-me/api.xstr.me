package me.xstr.api.models;

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
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name="mediatype",
discriminatorType=DiscriminatorType.INTEGER)
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Table(indexes = { @Index(columnList = "xstrMedia") })
public class ImdbRating implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3957215591730354433L;
	public ImdbRating(int id) {
		this.setImdbId(id);
		this.setAverageRating(0);
		this.setNumVotes(0);
	}

    @Id
    protected int imdbId;
    
    protected float averageRating;
    protected int numVotes;

    

}
