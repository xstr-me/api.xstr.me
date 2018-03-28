package me.xstr.api.batch.writers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.ItemWriterAdapter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import me.xstr.api.models.XstrMedia;
import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.repositories.ImdbRatingRepo;
import me.xstr.api.services.ImdbRatingService;
import me.xstr.api.services.XstrMediaService;

@Component
public class XstrMediaWriter extends ItemWriterAdapter<ImdbRating> {

	@Autowired
	private ImdbRatingService imdbRatingService;
	


	public XstrMediaWriter() {
		super();
	}
	
	@PostConstruct
	public void setDAO() {
		super.setTargetObject(imdbRatingService);
		super.setTargetMethod("save");
	}

}