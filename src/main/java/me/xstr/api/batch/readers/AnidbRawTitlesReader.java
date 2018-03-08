package me.xstr.api.batch.readers;

import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

import me.xstr.api.models.anidb.AnidbRawTitles;

@Component
public class AnidbRawTitlesReader extends StaxEventItemReader<AnidbRawTitles> {

	public AnidbRawTitlesReader() {

		super();
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setClassesToBeBound(AnidbRawTitles.class);
		super.setResource(new ClassPathResource("data/anidb/anime-titles.xml"));
		super.setFragmentRootElementName("anime");
		super.setUnmarshaller(jaxb2Marshaller);
		super.setCurrentItemCount(1);
	}

}
