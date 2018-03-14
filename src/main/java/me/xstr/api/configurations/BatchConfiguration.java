package me.xstr.api.configurations;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceInitializer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;

import me.xstr.api.batch.jobs.ImdbMediaJobs;
import me.xstr.api.batch.listeners.JobCompletionNotificationListener;

/*
 * https://github.com/cyriljoui/spring-batch/blob/master/src/main/java/com/cyriljoui/spring/poc/batch/config/BatchConfiguration.java
 * */

@Configuration
@EnableBatchProcessing
@Import(BatchSchedulerConfiguration.class)
public class BatchConfiguration extends DefaultBatchConfigurer {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

	@Autowired
	@Qualifier("batchDataSource")
	public DataSource batchDataSource;

	@Override
	@Autowired
	public void setDataSource(@Qualifier("batchDataSource") DataSource batchDataSource) {
		super.setDataSource(batchDataSource);
	}

	@Bean
	public BatchDataSourceInitializer batchDatabaseInitializer(@Qualifier("batchDataSource") DataSource batchDataSource,
			ResourceLoader resourceLoader, BatchProperties batchProperties) {
		return new BatchDataSourceInitializer(batchDataSource, resourceLoader, batchProperties);
	}

	@Autowired
	private SimpleJobLauncher jobLauncher;

	@Autowired
	private ImdbMediaJobs imdbMediaJobs;

	@Autowired
	public JobCompletionNotificationListener jobCompletionNotificationListener;

	@Scheduled(fixedDelayString = "${xstr.batch.cron.highfreq}")
	public void executeFastJob() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();

		JobExecution execution = jobLauncher.run(imdbMediaJobs.addImdbMediaJob(jobCompletionNotificationListener), param);

		log.info("Job finished with status :" + execution.getStatus());
	}
}
