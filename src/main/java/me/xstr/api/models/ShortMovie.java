package me.xstr.api.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("3")
public class ShortMovie extends XstrMedia {}
