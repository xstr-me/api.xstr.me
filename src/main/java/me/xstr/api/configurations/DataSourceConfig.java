package me.xstr.api.configurations;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@Primary
	@ConfigurationProperties("xstr.main.datasource")
	public DataSourceProperties xstrDataSourceProperties() {
	    return new DataSourceProperties();
	}	
	
	@Bean({"dataSource", "xstrDataSource"})
	@Primary
	@ConfigurationProperties("xstr.main.datasource")
	public DataSource xstrDataSource() {
	    return xstrDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@ConfigurationProperties("xstr.batch.job.datasource")
	public DataSourceProperties batchDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean("batchDataSource")
	@ConfigurationProperties("xstr.batch.job.datasource")
	public DataSource batchDataSource() {
	    return batchDataSourceProperties().initializeDataSourceBuilder().build();
	}
	
	@Bean
	@ConfigurationProperties("xstr.batch.staging.datasource")
	public DataSourceProperties batchStagingDataSourceProperties() {
	    return new DataSourceProperties();
	}

	@Bean("batchStagingDataSource")
	@ConfigurationProperties("xstr.batch.staging.datasource")
	public DataSource batchStagingDataSource() {
	    return batchStagingDataSourceProperties().initializeDataSourceBuilder().build();
	}

}
