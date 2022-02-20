package com.test.lld.scheduler.handler;

import com.test.lld.scheduler.model.Job;
import com.test.lld.scheduler.model.Message;

import java.util.List;

public interface JobHandler {

    public void handle(Job job);
}
