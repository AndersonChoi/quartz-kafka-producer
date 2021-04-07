package com.pipeline;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler scheduler = schedulerFactory.getScheduler();


            for (; ; ) {

                execute(scheduler);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void execute(Scheduler scheduler) throws SchedulerException {
        JobDetail job = newJob(TestJob.class)
                .build();

        Trigger trigger = newTrigger()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withRepeatCount(0)
                        .withIntervalInSeconds(20))
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
}