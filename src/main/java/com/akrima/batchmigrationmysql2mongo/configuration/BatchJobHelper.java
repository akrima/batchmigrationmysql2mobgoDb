package com.akrima.batchmigrationmysql2mongo.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public final class BatchJobHelper {

    public static BatchJobStatus run(Job job, JobLauncher jobLauncher) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

        BatchJobStatus batchJobStatus = new BatchJobStatus(
                jobExecution.getStatus().toString(),
                jobExecution.getExitStatus().toString(),
                jobExecution.getStartTime(),
                jobExecution.getEndTime(),
                jobExecution.getLastUpdated()
        );
        return batchJobStatus;
    }
}
