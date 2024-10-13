package com.solution.lld.scheduler.service;

import com.solution.lld.scheduler.dao.JobDao;
import com.solution.lld.scheduler.model.Job;

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
