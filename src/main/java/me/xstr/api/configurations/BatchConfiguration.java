package me.xstr.api.configurations;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.BatchConfigurationException;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceInitializer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import me.xstr.api.batch.listeners.JobCompletionNotificationListener;

/*
 * https://github.com/cyriljoui/spring-batch/blob/master/src/main/java/com/cyriljoui/spring/poc/batch/config/BatchConfiguration.java
 * */

@Configuration
@EnableBatchProcessing
@EnableScheduling
// @Import(BatchSchedulerConfiguration.class)
public class BatchConfiguration implements BatchConfigurer {

	private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

	@Autowired
	@Qualifier("batchDataSource")
	public DataSource batchDataSource;
	/*@Autowired
	@Qualifier("xstrDataSource")
	public DataSource xstrDataSource;*/
	
	
	private PlatformTransactionManager batchTransactionManager;
	private JobRepository jobRepository;
	private JobLauncher jobLauncher;
	private JobExplorer jobExplorer;
	private JobRegistry jobRegistry;
	private JobOperator jobOperator;

	@Autowired
	public JobCompletionNotificationListener jobCompletionNotificationListener;

	@Override
	public JobRepository getJobRepository() {
		return jobRepository;
	}

	@Override
	public PlatformTransactionManager getTransactionManager() {
		return batchTransactionManager;
	}

	@Override
	public JobLauncher getJobLauncher() {
		return jobLauncher;
	}

	@Override
	public JobExplorer getJobExplorer() {
		return jobExplorer;
	}
	
	public JobRegistry getJobRegistry() {
		return jobRegistry;
	}
	
	public JobOperator getJobOperator() {
		return jobOperator;
	}

	//@Bean
	public PlatformTransactionManager batchTransactionManager() {
		//LocalContainerEntityManagerFactoryBean lemf = new LocalContainerEntityManagerFactoryBean();
		//lemf.setDataSource(batchDataSource);
		//lemf.afterPropertiesSet();
		//JpaTransactionManager transactionManager = new JpaTransactionManager();
		//transactionManager.setDataSource(batchDataSource);
		//transactionManager.setEntityManagerFactory(lemf.getObject() );
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(batchDataSource);
		// transactionManager.afterPropertiesSet();
		return transactionManager;
	}
	
	/*@Bean
	@Primary
	public PlatformTransactionManager transactionManager() {
		
		return new DataSourceTransactionManager(xstrDataSource);
	}*/
	


	@Bean
	public BatchDataSourceInitializer batchDatabaseInitializer(@Qualifier("batchDataSource") DataSource batchDataSource,
			ResourceLoader resourceLoader, BatchProperties batchProperties) {
		return new BatchDataSourceInitializer(batchDataSource, resourceLoader, batchProperties);
	}

	// @Scheduled(fixedDelayString = "${xstr.batch.cron.highfreq}")
	@Scheduled(fixedDelayString = "30000")
	public void executeFastJob() throws Exception {
		log.info("total Jobs = {}", getJobOperator().getJobNames().size());
		for (String jobName : getJobOperator().getJobNames()) {
			getJobOperator().startNextInstance(jobName);
		}
	}

	public JobLauncher createJobLauncher() throws Exception {
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		//launcher.setTaskExecutor(taskExecutor());
		launcher.afterPropertiesSet();
		return launcher;
	}

	protected JobRepository createJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(batchDataSource);
		factory.setTransactionManager(batchTransactionManager);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	protected JobExplorer createJobExplorer() throws Exception {
		JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
		jobExplorerFactoryBean.setDataSource(batchDataSource);
		jobExplorerFactoryBean.afterPropertiesSet();
		return jobExplorerFactoryBean.getObject();
	}

	public JobRegistry createJobRegistry() {
		return new MapJobRegistry();
	}

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() throws DuplicateJobException {
		JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
		postProcessor.setJobRegistry(jobRegistry);
		return postProcessor;
	}

	@Bean
	public MapJobRepositoryFactoryBean mapJobRepositoryFactory() throws Exception {
		MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(batchTransactionManager);
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	public JobBuilderFactory jobBuilderFactory() {
		return new JobBuilderFactory(jobRepository);
	}

	@Bean
	public StepBuilderFactory stepBuilderFactory() {
		return new StepBuilderFactory(jobRepository, batchTransactionManager);
	}

	public JobOperator createJobOperator() throws Exception {
		SimpleJobOperator operator = new SimpleJobOperator();
		operator.setJobRepository(jobRepository);
		operator.setJobLauncher(jobLauncher);
		operator.setJobRegistry(jobRegistry);
		operator.setJobExplorer(jobExplorer);
		operator.afterPropertiesSet();
		return operator;
	}

	@Bean
	public TaskScheduler getTaskScheduler() {
		return new ConcurrentTaskScheduler();
	}

	/*@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(16);
		executor.setThreadPriority(1);
		executor.afterPropertiesSet();
		return executor;
	}*/

	@PostConstruct
	public void initialize() {
		try {
			this.batchTransactionManager = batchTransactionManager();
			this.jobRepository = createJobRepository();
			this.jobExplorer = createJobExplorer();
			this.jobLauncher = createJobLauncher();
			this.jobRegistry = createJobRegistry();
			this.jobOperator = createJobOperator();

		} catch (Exception e) {
			throw new BatchConfigurationException(e);
		}
	}
}
