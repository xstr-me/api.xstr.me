package me.xstr.api.batch.steps;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import me.xstr.api.batch.processors.ImdbMediaItemProcessor;
import me.xstr.api.batch.readers.ImdbRawMediaReader;
import me.xstr.api.batch.writers.ImdbMediaWriter;
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

	@Bean
	public Step imdbRawMediaStep() {

		return stepBuilderFactory.get("ImdbRawMediaStep").<ImdbRawMedia, ImdbMedia>chunk(10).reader(imdbRawMediaReader)
				.processor(imdbMediaItemProcessor).writer(imdbMediaWriter).build();

	}

}
