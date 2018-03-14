package me.xstr.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Engine {

	private static final Logger log = LoggerFactory.getLogger(Engine.class);

	public static void main(String[] args) {
		SpringApplication.run(Engine.class, args);

		log.info("\n\n"
				+ 	"  ___ ______ _____ __   __    _                       \n" + 
					" / _ \\| ___ \\_   _|\\ \\ / /   | |                      \n" + 
					"/ /_\\ \\ |_/ / | |   \\ V / ___| |_ _ __ _ __ ___   ___ \n" + 
					"|  _  |  __/  | |   /   \\/ __| __| '__| '_ ` _ \\ / _ \\\n" + 
					"| | | | |    _| |__/ /^\\ \\__ \\ |_| |_ | | | | | |  __/\n" + 
					"\\_| |_|_|    \\___(_)/   \\/___/\\__|_(_)|_| |_| |_|\\___|\n" + 
					"                                                      \n" + 
					"                                                      ");
	}

}
