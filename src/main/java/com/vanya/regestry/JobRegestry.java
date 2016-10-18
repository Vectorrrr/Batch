package com.vanya.regestry;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.NoSuchJobException;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class JobRegestry implements JobLocator{
    @Override
    public Job getJob(String name) throws NoSuchJobException {
        return new Job() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public boolean isRestartable() {
                return false;
            }

            @Override
            public void execute(JobExecution execution) {

            }

            @Override
            public JobParametersIncrementer getJobParametersIncrementer() {
                return null;
            }

            @Override
            public JobParametersValidator getJobParametersValidator() {
                return null;
            }
        };
    }
}
