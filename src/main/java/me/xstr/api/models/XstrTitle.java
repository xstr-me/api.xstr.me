package me.xstr.api.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.xstr.api.models.imdb.ImdbRating;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XstrTitle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2609831665710002709L;

	private static final Logger log = LoggerFactory.getLogger(XstrTitle.class);
	
	public XstrTitle(String title) {
		this.title = title;
		this.uuid = UUID.nameUUIDFromBytes(("xstr.me-" + title + "-uuid").getBytes());
		log.info("------ title {} => UUID {}", this.title, this.uuid);
		
	}

	@Id
	private UUID uuid;
	//@Lob
	@Column(columnDefinition="TEXT",nullable=false,unique=true)
	private String title;

}
