package me.xstr.api.batch.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import me.xstr.api.batch.processors.AnidbTitlesItemProcessor;
import me.xstr.api.batch.processors.ImdbMediaItemProcessor;
import me.xstr.api.batch.processors.XstrMediaItemProcessor;
import me.xstr.api.batch.readers.AnidbRawTitlesReader;
import me.xstr.api.batch.readers.ImdbRawMediaReader;
import me.xstr.api.batch.writers.AnidbTitlesWriter;
import me.xstr.api.batch.writers.XstrMediaWriter;
import me.xstr.api.models.anidb.AnidbRawTitles;
import me.xstr.api.models.anidb.AnidbTitles;
import me.xstr.api.models.imdb.ImdbRating;
import me.xstr.api.models.imdb.ImdbRawMedia;

@Component
public class ImdbRawMediaSteps {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ImdbRawMediaReader imdbRawMediaReader;

	@Autowired
	public ImdbMediaItemProcessor imdbMediaItemProcessor;
	
	@Autowired
	private AnidbRawTitlesReader anidbRawTitlesReader;

	@Autowired
	public AnidbTitlesItemProcessor anidbTitlesItemProcessor;

	@Autowired
	private AnidbTitlesWriter anidbTitlesWriter;
	
	@Autowired
	private XstrMediaItemProcessor xstrMediaItemProcessor;
	
	@Autowired
	private XstrMediaWriter xstrMediaWriter;

	@Bean
	public Step imdbRawMediaStep() {

		return stepBuilderFactory.get("ImdbRawMediaStep")
				.<ImdbRawMedia, ImdbRating>chunk(1)
				.reader(imdbRawMediaReader)
				.processor(xstrMediaItemProcessor)
				.writer(xstrMediaWriter)
				.build();

	}

	@Bean
	public Step anidbRawTitlesStep() {

		return stepBuilderFactory.get("AnidbRawTitlesStep").<AnidbRawTitles, AnidbTitles>chunk(5).reader(anidbRawTitlesReader)
				.processor(anidbTitlesItemProcessor).writer(anidbTitlesWriter).build();

	}

}
