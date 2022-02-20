package com.test.lld.scheduler.service;

import com.test.lld.scheduler.model.Job;

public interface JobService {

    public void createJob(Job job);

    public Job getJob(String name);

}
