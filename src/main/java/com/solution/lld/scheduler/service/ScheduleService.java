package com.solution.lld.scheduler.service;


import com.solution.lld.scheduler.model.Schedule;
import com.solution.lld.scheduler.types.ScheduleStatus;

import java.util.List;

public interface ScheduleService {

    public void createSchedule(Schedule schedule);

    public Schedule getSchedule(String name);

    public void updateScheduleStatus(String name, ScheduleStatus status);

    public List<Schedule> getSchedulesByStatus(long currentTimeInMilliSecondds, List<ScheduleStatus> statuses);

}
