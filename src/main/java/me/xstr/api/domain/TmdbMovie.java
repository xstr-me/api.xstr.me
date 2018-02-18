package me.xstr.api.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TmdbMovie {
	
	@Id
    private long id;
    private String title;
    private String originalTitle;
    private String originalLanguage;

}
