package me.xstr.api.batch.writers;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.xstr.api.models.ImdbMedia;
import me.xstr.api.repositories.ImdbMediaRepo;

@Component
public class ImdbMediaWriter extends RepositoryItemWriter<ImdbMedia> {

	@Autowired
	private ImdbMediaRepo repository;

	public ImdbMediaWriter() {
		super();
		
		super.setMethodName("save");
	}
	
	@PostConstruct
	public void setRepository() {
		super.setRepository(repository);
	}

}
