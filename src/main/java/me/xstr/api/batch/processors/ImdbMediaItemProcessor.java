package me.xstr.api.batch.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import me.xstr.api.models.imdb.ImdbMedia;
import me.xstr.api.models.imdb.ImdbRawMedia;

@Component
public class ImdbMediaItemProcessor implements ItemProcessor<ImdbRawMedia, ImdbMedia> {
	
	private static final Logger log = LoggerFactory.getLogger(ImdbMediaItemProcessor.class);
	
	@Override
	public ImdbMedia process(final ImdbRawMedia imdbRawMedia) throws Exception {
		
		return new ImdbMedia(imdbRawMedia);
	}
}
