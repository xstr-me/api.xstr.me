package me.xstr.xstrapi;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		Environment env = SpringApplication.run(Application.class, args).getEnvironment();

		try {
			log.info("\n\n***********************************************************\n\t"
					+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}{}\n\t"
					+ "External: \thttp://{}:{}{}" + "\n***********************************************************\n\n",
					env.getProperty("spring.application.name"), env.getProperty("server.port"),
					env.getProperty("server.context-path"), InetAddress.getLocalHost().getHostAddress(),
					env.getProperty("server.port"), env.getProperty("server.context-path"));
		} catch (UnknownHostException e) {
			log.error("can't get host adresse");
		}
	}
}
