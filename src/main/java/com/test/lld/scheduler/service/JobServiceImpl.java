package com.test.lld.scheduler.service;

import com.test.lld.scheduler.dao.JobDao;
import com.test.lld.scheduler.model.Job;
import com.test.lld.scheduler.model.Schedule;
import com.test.lld.scheduler.types.ScheduleStatus;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class JobServiceImpl implements JobService{

    private JobDao jobDao;

    public JobServiceImpl(){
        this.jobDao = new JobDao();
    }
    @Override
    public void createJob(Job job) {
        this.jobDao.createJob(job);
    }

    @Override
    public Job getJob(String name) {
        return this.jobDao.getJob(name);
    }

}
