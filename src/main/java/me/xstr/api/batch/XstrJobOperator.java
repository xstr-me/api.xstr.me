/*package me.xstr.api.batch;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XstrJobOperator extends SimpleJobOperator{
	
	@Autowired
	private JobExplorer jobExplorer;

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private JobRegistry jobRegistry;
	
	@PostConstruct
	public void initJobOperator() {
		this.setJobExplorer(jobExplorer);
		this.setJobLauncher(jobLauncher);
		this.setJobRepository(jobRepository);
		this.setJobRegistry(jobRegistry);
	}

}*/
