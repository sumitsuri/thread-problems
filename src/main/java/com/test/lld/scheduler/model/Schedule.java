package com.test.lld.scheduler.model;


import com.test.lld.scheduler.types.ScheduleStatus;
import com.test.lld.scheduler.types.ScheduleType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Schedule {

    private String id;
    private String name;
    private String jobName;
    private String createdBy;
    private String updatedBy;
    private AtomicLong nextRunAt;
    private ScheduleType scheduleType;
    private ScheduleStatus scheduleStatus;

    //skip this schedule..
    public Schedule(String name, String jobName, String createdBy, ScheduleType scheduleType){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.jobName = jobName;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        this.scheduleType = scheduleType;
        this.nextRunAt = getNextSchedule(System.currentTimeMillis());
        this.scheduleStatus = ScheduleStatus.NEW;

    }

    public AtomicLong getNextSchedule(long currentTime){
        switch (scheduleType){
            case DAILY:
                //return upcoming 12:00 am time in milliseconds
            case WEEKLY:
                //return upcoming 12:00 am time + 7 days in milliseconds
            case HOURLY:
                //return upcoming hourtime in milliseconds
            default:
                throw new RuntimeException(String.format("schedule type [%s] not supported", scheduleType));
        }
    }
}
