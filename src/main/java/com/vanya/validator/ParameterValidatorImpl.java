package com.vanya.validator;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

/**
 * Created by Hladush Ivan
 * on 14.10.16.
 */
public class ParameterValidatorImpl implements JobParametersValidator{
    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        System.out.println("Start validate parameters");
        System.out.println(parameters);
        System.out.println("finished validate parameters");
    }
}
