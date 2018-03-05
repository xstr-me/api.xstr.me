package me.xstr.api.batch.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import me.xstr.api.batch.processors.AnidbTitlesItemProcessor;
import me.xstr.api.batch.processors.ImdbMediaItemProcessor;
import me.xstr.api.batch.readers.AnidbRawTitlesReader;
import me.xstr.api.batch.readers.ImdbRawMediaReader;
import me.xstr.api.batch.writers.AnidbTitlesWriter;
import me.xstr.api.batch.writers.ImdbMediaWriter;
import me.xstr.api.models.AnidbRawTitles;
import me.xstr.api.models.AnidbTitles;
import me.xstr.api.models.ImdbMedia;
import me.xstr.api.models.ImdbRawMedia;

@Component
public class ImdbRawMediaSteps {

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private ImdbRawMediaReader imdbRawMediaReader;

	@Autowired
	public ImdbMediaItemProcessor imdbMediaItemProcessor;

	@Autowired
	private ImdbMediaWriter imdbMediaWriter;
	
	@Autowired
	private AnidbRawTitlesReader anidbRawTitlesReader;

	@Autowired
	public AnidbTitlesItemProcessor anidbTitlesItemProcessor;

	@Autowired
	private AnidbTitlesWriter anidbTitlesWriter;

	@Bean
	public Step imdbRawMediaStep() {

		return stepBuilderFactory.get("ImdbRawMediaStep").<ImdbRawMedia, ImdbMedia>chunk(10).reader(imdbRawMediaReader)
				.processor(imdbMediaItemProcessor).writer(imdbMediaWriter).build();

	}

	@Bean
	public Step anidbRawTitlesStep() {

		return stepBuilderFactory.get("AnidbRawTitlesStep").<AnidbRawTitles, AnidbTitles>chunk(100).reader(anidbRawTitlesReader)
				.processor(anidbTitlesItemProcessor).writer(anidbTitlesWriter).build();

	}

}
