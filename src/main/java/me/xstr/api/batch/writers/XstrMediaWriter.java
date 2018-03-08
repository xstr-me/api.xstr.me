package me.xstr.api.batch.writers;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.repositories.ImdbRatingRepo;

@Component
public class XstrMediaWriter extends RepositoryItemWriter<ImdbRating> {

	@Autowired
	private ImdbRatingRepo repository;

	public XstrMediaWriter() {
		super();
		
		super.setMethodName("save");
	}

	@PostConstruct
	public void setRepository() {
		super.setRepository(repository);
	}

}