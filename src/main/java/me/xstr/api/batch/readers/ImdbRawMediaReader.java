package me.xstr.api.batch.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import me.xstr.api.models.ImdbRawMedia;

@Component
public class ImdbRawMediaReader extends FlatFileItemReader<ImdbRawMedia> {

	public ImdbRawMediaReader() {

		super();

		BeanWrapperFieldSetMapper<ImdbRawMedia> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
		beanWrapperFieldSetMapper.setTargetType(ImdbRawMedia.class);

		ImdbTsvDelimitedLineTokenizer delimitedLineTokenizer = new ImdbTsvDelimitedLineTokenizer();
		delimitedLineTokenizer.setNames(new String[] { "tconst", "titleType", "primaryTitle", "originalTitle",
				"isAdult", "startYear", "endYear", "runtimeMinutes", "genres" });

		DefaultLineMapper<ImdbRawMedia> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

		super.setResource(new ClassPathResource("data/imdb/title.basics.tsv"));
		super.setLineMapper(defaultLineMapper);
		super.setCurrentItemCount(399);
	}

}
