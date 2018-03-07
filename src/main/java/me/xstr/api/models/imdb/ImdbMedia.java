package me.xstr.api.models.imdb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.xstr.api.models.MediaType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImdbMedia {
	
	@Id
    private int imdbId;    
    @Column(length=10)
    private String titleType;    
    @Column(length=25)
    private String primaryTitle;
    @Column(length=25)
    private String originalTitle;
    private boolean isAdult;
    private Date startYear;
    private Date endYear;
    private int runtimeMinutes;
    @Column(length=25)
    private String genres;

}
