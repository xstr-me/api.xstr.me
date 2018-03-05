package me.xstr.api.models;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Entity
@DiscriminatorValue("1")
public class ImdbMovieRating extends ImdbRating {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6410373365600543099L;

	public ImdbMovieRating(int id){
		super(id);
	}
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="xstrMedia")
	private Movie movie;
}
