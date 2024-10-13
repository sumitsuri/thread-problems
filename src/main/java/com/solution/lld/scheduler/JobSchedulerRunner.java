package com.solution.lld.scheduler;

import com.solution.lld.scheduler.cron.JobSelectorCron;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class JobSchedulerRunner {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor threadPool
                = new ScheduledThreadPoolExecutor(1);
        threadPool.schedule(new JobSelectorCron(), 1, TimeUnit.MINUTES);
    }
}
