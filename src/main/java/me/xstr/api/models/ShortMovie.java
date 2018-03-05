package me.xstr.api.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("3")
public class ShortMovie extends XstrMedia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6924138917935553012L;}
