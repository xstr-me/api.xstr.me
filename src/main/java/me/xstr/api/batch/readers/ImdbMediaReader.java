package me.xstr.api.batch.readers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.repositories.ImdbMediaRepo;

@Component
public class ImdbMediaReader extends RepositoryItemReader<ImdbMedia> {

	@Autowired
	private ImdbMediaRepo repository;
	
	public ImdbMediaReader() {

		super();

	    Map<String, Direction> sort = new HashMap<>();
	    sort.put("imdbId", Direction.ASC);
		super.setSort(sort);
		super.setMethodName("findAll");
	}
	
	@PostConstruct
	public void setRepository() {
		super.setRepository(repository);
	}

}
