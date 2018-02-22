package me.xstr.api.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int tmdbId;
	private int imdbId;
	private String originalTitle;
	private Date releaseDate;
	private String originalLanguage;

}
