package com.solution.lld.scheduler.service;

import com.solution.lld.scheduler.model.Job;

public interface JobService {

    public void createJob(Job job);

    public Job getJob(String name);

}
