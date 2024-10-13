package com.solution.lld.scheduler.dao;

import com.google.common.collect.Maps;
import com.solution.lld.scheduler.model.Job;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JobDao {

    private Map<String, Job> jobStore;

    public JobDao(){
        this.jobStore = Maps.newConcurrentMap();
    }

    public void createJob(Job job){
        if(this.jobStore.containsKey(job.getName())){
            throw new RuntimeException(String.format("Job: [%s] already exists"));
        }
        this.jobStore.put(job.getName(), job);
    }

    public Job getJob(String name){
        if(!this.jobStore.containsKey(name)){
            throw new RuntimeException(String.format("Job: [%s] not found", name));
        }
        return this.jobStore.get(name);
    }

    public List<Job> getAllJobs(){
        return this.jobStore.values().stream().collect(Collectors.toList());
    }
}
