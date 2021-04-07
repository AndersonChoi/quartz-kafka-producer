package com.pipeline;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class TestJob implements Job {
    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        ProduceTest.getInstance().send(new Date(System.currentTimeMillis()) + "]");
    }
}