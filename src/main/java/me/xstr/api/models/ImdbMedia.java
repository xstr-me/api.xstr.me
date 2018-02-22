package me.xstr.api.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImdbMedia {
	
	@Id
    private int imdbId;
    private Enum<ImdbMediaType> titleType;
    private String primaryTitle;
    private String originalTitle;
    private boolean isAdult;
    private Date startYear;
    private Date endYear;
    private int runtimeMinutes;
    private String genres;

}
