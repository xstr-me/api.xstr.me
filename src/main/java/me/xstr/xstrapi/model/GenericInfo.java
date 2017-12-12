package me.xstr.xstrapi.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class GenericInfo {
	
	@Value("${api.version}")
	private String version;

	private String name;
	private String description;
	
	
	public GenericInfo() {
		this.name = "api.xstr.me";
		this.description = "default static description";
	}

	public String getName() {
		return this.name;
	}
	public String getVersion() {
		return this.version;
	}
	public String getDescription() {
		return this.description;
	}
	
	

}
