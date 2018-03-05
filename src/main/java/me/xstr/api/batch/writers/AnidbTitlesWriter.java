package me.xstr.api.batch.writers;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.xstr.api.models.AnidbTitles;
import me.xstr.api.repositories.AnidbTitlesRepo;

@Component
public class AnidbTitlesWriter extends RepositoryItemWriter<AnidbTitles> {

	@Autowired
	private AnidbTitlesRepo repository;

	public AnidbTitlesWriter() {
		super();
		super.setMethodName("save");
	}
	
	@PostConstruct
	public void setRepository() {
		super.setRepository(repository);
	}

}
