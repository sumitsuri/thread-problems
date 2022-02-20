package com.test.lld.scheduler.service;


import com.google.common.collect.Lists;
import com.test.lld.scheduler.model.Job;
import lombok.Getter;

import java.util.List;

@Getter
public class JobSchedulerService {

    private JobService jobService;
    private ScheduleService scheduleService;

    public JobSchedulerService(){
        this.jobService = new JobServiceImpl();
        this.scheduleService = new ScheduleServiceImpl();
    }

}
