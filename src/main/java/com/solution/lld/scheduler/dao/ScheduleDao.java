package com.solution.lld.scheduler.dao;

import com.google.common.collect.Maps;
import com.solution.lld.scheduler.model.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScheduleDao {

    private Map<String, Schedule> scheduleStore;

    public ScheduleDao(){
        this.scheduleStore = Maps.newConcurrentMap();
    }

    //TODO: Need to be synchronised as
    public void create(Schedule schedule){
        if(this.scheduleStore.containsKey(schedule.getName())){
            throw new RuntimeException(String.format("Schedule: [%s] already exists"));
        }
        this.scheduleStore.put(schedule.getName(), schedule);
    }

    public Schedule get(String name){
        if(!this.scheduleStore.containsKey(name)){
            throw new RuntimeException(String.format("Schedule: [%s] not found", name));
        }
        return this.scheduleStore.get(name);
    }
    public List<Schedule> getAll(){
        return new ArrayList<>(this.scheduleStore.values());
    }
}
