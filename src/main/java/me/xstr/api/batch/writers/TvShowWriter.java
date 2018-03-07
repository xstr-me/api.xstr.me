package me.xstr.api.batch.writers;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.xstr.api.models.TvShow;
import me.xstr.api.repositories.TvShowRepo;

@Component
public class TvShowWriter extends RepositoryItemWriter<TvShow> {

	@Autowired
	private TvShowRepo repository;

	public TvShowWriter() {
		super();
		
		super.setMethodName("save");
	}
	
	@PostConstruct
	public void setRepository() {
		super.setRepository(repository);
	}

}
