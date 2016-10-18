package com.vanya.config;

import com.vanya.converter.PersonConverter;
import com.vanya.listener.JobExecutionListenerImpl;
import com.vanya.listener.StepListenerImpl;
import com.vanya.model.Person;
import com.vanya.step.processor.PersonItemProcessor;
import com.vanya.step.reader.FileReader;
import com.vanya.step.writer.FileWriter;
import com.vanya.validator.ParameterValidatorImpl;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.batch.api.listener.StepListener;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobFactory;

    @Autowired
    public StepBuilderFactory stepFactory;

    @Bean
    public JobExecutionListener getListener(){
        return new JobExecutionListenerImpl();
    }

    @Bean
    public Converter<String,Person> getConverter(){
        return new PersonConverter<String,Person>();
    }
    @Bean
    public FileReader reader(){
        return new FileReader("sample-data.csv");
    }
    @Bean
    public PersonItemProcessor processor(){
        return new PersonItemProcessor();
    }
    @Bean
    public FileWriter writer(){
        return new FileWriter();
    }
    @Bean
    public JobParametersValidator getValidator(){
        return new ParameterValidatorImpl();
    }
    @Bean(name = "job")
    public Job importUserJob(){
//        return jobFactory.get("MyFirstJob").start(step1()).preventRestart().build();
        return jobFactory.get("MyFirstJob").start(step1()).validator(getValidator()).listener(getListener()).build();
    }
    @Bean
    public Step step1(){
        return stepFactory
                .get("step1")
                .<Person,Person>chunk(2)
                .reader(reader())
                .writer(writer())
                .processor(processor())
                .startLimit(10)
                .listener(getStepListener())
                .build();
    }

    @Bean
    public StepListener getStepListener(){
        return new StepListenerImpl();
    }

    @Bean
    public JobRepository jobRepository() throws Exception {
//        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
//        jobRepositoryFactoryBean.setDatabaseType("db2");
//        jobRepositoryFactoryBean.setDataSource();
        return new MapJobRepositoryFactoryBean(transactionManager()).getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new ResourcelessTransactionManager();
    }

    @Bean(name = "launcher")
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository());
        return jobLauncher;
    }
}