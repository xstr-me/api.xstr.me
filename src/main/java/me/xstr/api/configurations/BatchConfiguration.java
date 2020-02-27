package me.xstr.api.configurations;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceInitializer;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.autoconfigure.batch.JpaBatchConfigurer;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration extends JpaBatchConfigurer {

	protected BatchConfiguration(BatchProperties properties, @Qualifier("batchDataSource") DataSource dataSource,
			TransactionManagerCustomizers transactionManagerCustomizers, EntityManagerFactory entityManagerFactory) {
		super(properties, dataSource, transactionManagerCustomizers, entityManagerFactory);
	}

	@Bean
	public BatchDataSourceInitializer batchDatabaseInitializer(@Qualifier("batchDataSource") DataSource batchDataSource,
			ResourceLoader resourceLoader, BatchProperties batchProperties) {
		return new BatchDataSourceInitializer(batchDataSource, resourceLoader, batchProperties);
	}

	/*@Bean
	public JobRegistry jobRegistry() {
		return new MapJobRegistry();
	}*/

	@Bean
	public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry)
			throws DuplicateJobException {
		JobRegistryBeanPostProcessor postProcessor = new JobRegistryBeanPostProcessor();
		postProcessor.setJobRegistry(jobRegistry);
		return postProcessor;
	}

	@Bean
	public MapJobRepositoryFactoryBean mapJobRepositoryFactory(PlatformTransactionManager transactionManager)
			throws Exception {
		MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(transactionManager);
		factory.afterPropertiesSet();
		return factory;
	}

	@Bean
	public TaskScheduler getTaskScheduler() {
		return new ConcurrentTaskScheduler();
	}

	@Bean
	public TaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setMaxPoolSize(16);
		executor.setThreadPriority(1);
		executor.afterPropertiesSet();
		return executor;
	}
}