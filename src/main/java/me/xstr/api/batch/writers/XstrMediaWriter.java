/*package me.xstr.api.batch.writers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.stereotype.Component;

import me.xstr.api.models.Movie;
import me.xstr.api.models.TvShow;
import me.xstr.api.models.XstrMedia;

@Component
public class XstrMediaWriter extends CompositeItemWriter<XstrMedia> {


	public XstrMediaWriter() {
		super();
		MovieWriter movieWriter = new MovieWriter();
		TvShowWriter tvShowWriter = new TvShowWriter();
		List<ItemWriter<? extends XstrMedia>> delegates = Arrays.asList(movieWriter, tvShowWriter);
		// super.setDelegates(delegates);
	}

}*/
