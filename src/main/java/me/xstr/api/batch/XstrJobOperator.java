package me.xstr.api.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class XstrJobOperator {
	private static final Logger log = LoggerFactory.getLogger(XstrJobOperator.class);
	@Autowired
	private JobOperator jobOperator;
	@Scheduled(fixedDelayString = "${xstr.batch.cron.highfreq}")
	public void executeFastJob() throws Exception {
		log.info("total Jobs = {}", jobOperator.getJobNames().size());
		for (String jobName : jobOperator.getJobNames()) {
			jobOperator.startNextInstance(jobName);
		}
	}

}
