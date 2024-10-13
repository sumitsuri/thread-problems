package com.solution.lld.scheduler.handler;

import com.solution.lld.scheduler.model.Job;

public interface JobHandler {

    public void handle(Job job);
}
