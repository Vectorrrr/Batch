package com.vanya.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class JobExecutionListenerImpl  implements JobExecutionListener{
    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Job started with parameter: "+jobExecution.getJobParameters().toString());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("Job finished: " + jobExecution.getJobConfigurationName());
        }else{
            System.out.println("Sheet happens");
        }
    }
}
