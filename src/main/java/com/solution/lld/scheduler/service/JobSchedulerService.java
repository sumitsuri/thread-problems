package com.solution.lld.scheduler.service;


import lombok.Getter;

@Getter
public class JobSchedulerService {

    private JobService jobService;
    private ScheduleService scheduleService;

    public JobSchedulerService(){
        this.jobService = new JobServiceImpl();
        this.scheduleService = new ScheduleServiceImpl();
    }

}
