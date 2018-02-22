package me.xstr.api.batch.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import me.xstr.api.models.ImdbMedia;
import me.xstr.api.models.ImdbRawMedia;

@Component
public class ImdbMediaItemProcessor implements ItemProcessor<ImdbRawMedia, ImdbMedia> {

    private static final Logger log = LoggerFactory.getLogger(ImdbMediaItemProcessor.class);

    @Override
    public ImdbMedia process(final ImdbRawMedia imdbRawMedia) throws Exception {

        final ImdbMedia transformedImdbMedia = new ImdbMedia();
        transformedImdbMedia.setImdbId(Integer.parseInt(imdbRawMedia.getTconst().substring(2)));
        transformedImdbMedia.setOriginalTitle(imdbRawMedia.getOriginalTitle());
        

        log.info("Converting ({}) into ({})", imdbRawMedia, transformedImdbMedia);

        return transformedImdbMedia;
    }

}
