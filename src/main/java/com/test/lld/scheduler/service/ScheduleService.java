package com.test.lld.scheduler.service;


import com.test.lld.scheduler.model.Job;
import com.test.lld.scheduler.model.Schedule;
import com.test.lld.scheduler.types.ScheduleStatus;

import java.util.List;

public interface ScheduleService {

    public void createSchedule(Schedule schedule);

    public Schedule getSchedule(String name);

    public void updateScheduleStatus(String name, ScheduleStatus status);

    public List<Schedule> getSchedulesByStatus(long currentTimeInMilliSecondds, List<ScheduleStatus> statuses);

}
