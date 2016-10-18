package com.vanya;

import com.vanya.config.BatchConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.Launcher;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class Runner {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(BatchConfiguration.class);
        JobLauncher launcher = context.getBean("launcher", JobLauncher.class);
        Job job = context.getBean("job", Job.class);
        launcher.run(job,new JobParameters());
    }
}
