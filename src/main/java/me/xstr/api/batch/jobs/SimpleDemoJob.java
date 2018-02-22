package me.xstr.api.batch.jobs;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import me.xstr.api.batch.listeners.JobCompletionNotificationListener;

@Component
public class SimpleDemoJob {

	@Autowired
	@Qualifier("batchStagingDataSource")
	public DataSource batchStagingDataSource;

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	Step imdbRawMediaStep;
	
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(imdbRawMediaStep).end().build();
	}

}
