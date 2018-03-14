package me.xstr.api.batch.readers;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import me.xstr.api.batch.utils.GzipLazyResource;
import me.xstr.api.batch.utils.ImdbTsvDelimitedLineTokenizer;
import me.xstr.api.models.imdb.ImdbRawMedia;

@Component
public class ImdbRawMediaReader extends FlatFileItemReader<ImdbRawMedia> {

	public ImdbRawMediaReader() throws MalformedURLException, URISyntaxException {

		super();

		BeanWrapperFieldSetMapper<ImdbRawMedia> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(ImdbRawMedia.class);

		ImdbTsvDelimitedLineTokenizer delimitedLineTokenizer = new ImdbTsvDelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("tconst", "titleType", "primaryTitle", "originalTitle",
				"isAdult", "startYear", "endYear", "runtimeMinutes", "genres");

		DefaultLineMapper<ImdbRawMedia> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		
		//URL url = new URL("https://datasets.imdbws.com/title.basics.tsv.gz");
		//super.setResource(new GzipLazyResource(url));
		super.setResource(new ClassPathResource("data/imdb/title.basics.tsv"));
		super.setLineMapper(defaultLineMapper);
		super.setLinesToSkip(1);
		super.setCurrentItemCount(0); // or (399)
	}

}
