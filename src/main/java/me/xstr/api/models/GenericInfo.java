package me.xstr.api.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class GenericInfo {
	
	@Value("${api.version}")
	private String version;
	
	@Value("${spring.application.name}")
	private String serverName;
	
	@Value("${xstr.main.datasource.username}")
	private String dbUserName;
	
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
	public String getServerName() {
		return this.serverName;
	}
	public String getDbUserName() {
		return this.dbUserName;
	}
	
	

}
