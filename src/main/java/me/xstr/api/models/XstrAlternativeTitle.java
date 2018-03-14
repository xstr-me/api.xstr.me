package me.xstr.api.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XstrAlternativeTitle {

	@Id
	private int id;
	@ManyToOne
	private XstrTitle xstrTitle;

	private String language;

	private boolean isOfficial;

}
