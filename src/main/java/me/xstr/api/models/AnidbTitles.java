package me.xstr.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnidbTitles {
	
	@Id
    private int anidbId;
    private String originalTitle;
    private String originalLanguage;

}
