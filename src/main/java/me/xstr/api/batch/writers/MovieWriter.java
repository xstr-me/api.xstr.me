package me.xstr.api.batch.writers;

import javax.annotation.PostConstruct;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.xstr.api.models.Movie;
import me.xstr.api.repositories.MovieRepo;

@Component
public class MovieWriter extends RepositoryItemWriter<Movie> {

	@Autowired
	private MovieRepo repository;

	public MovieWriter() {
		super();
		
		super.setMethodName("save");
	}
	
	@PostConstruct
	public void setRepository() {
		super.setRepository(repository);
	}

}
