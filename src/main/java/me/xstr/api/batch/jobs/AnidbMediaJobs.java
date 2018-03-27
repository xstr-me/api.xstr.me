package me.xstr.api.batch.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import me.xstr.api.batch.listeners.JobCompletionNotificationListener;

@Component
public class AnidbMediaJobs {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	Step anidbRawTitlesStep;
	
	@Bean
	public Job importAniDBJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("importAniDBJob").incrementer(new RunIdIncrementer()).listener(listener)
				.flow(anidbRawTitlesStep)
				.end().build();
	}

}
