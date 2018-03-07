package me.xstr.api.batch.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import me.xstr.api.models.anidb.AnidbRawTitles;
import me.xstr.api.models.anidb.AnidbTitles;

@Component
public class AnidbTitlesItemProcessor implements ItemProcessor<AnidbRawTitles, AnidbTitles> {

private static final Logger log = LoggerFactory.getLogger(ImdbMediaItemProcessor.class);

@Override
public AnidbTitles process(final AnidbRawTitles anidbRawTitles) throws Exception {

    final AnidbTitles transformedAnidbTitles = new AnidbTitles();
    transformedAnidbTitles.setAnidbId(anidbRawTitles.getAid());
    transformedAnidbTitles.setOriginalTitle(anidbRawTitles.getTitles().get(0).getTitle());
    transformedAnidbTitles.setOriginalLanguage(anidbRawTitles.getTitles().get(0).getLanguage());
    

    log.info("###########   Converting ({}) into ({})", anidbRawTitles, transformedAnidbTitles);

    return transformedAnidbTitles;
}

}