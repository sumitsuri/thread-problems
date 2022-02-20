package com.test.lld.scheduler.service;

import com.test.lld.scheduler.dao.ScheduleDao;
import com.test.lld.scheduler.model.Schedule;
import com.test.lld.scheduler.types.ScheduleStatus;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ScheduleServiceImpl implements ScheduleService{

    private ScheduleDao scheduleDao;

    public ScheduleServiceImpl(){
        this.scheduleDao = new ScheduleDao();
    }

    @Override
    public void createSchedule(Schedule schedule) {
        this.createSchedule(schedule);
    }

    @Override
    public Schedule getSchedule(String name) {
        return this.getSchedule(name);
    }

    @Override
    public synchronized void updateScheduleStatus(String name, ScheduleStatus status) {
        Schedule schedule = getSchedule(name);
        schedule.setScheduleStatus(status);
        new ConcurrentHashMap<>().putIfAbsent("1","2");
    }


    @Override
    public List<Schedule> getSchedulesByStatus(long currentTimeInMilliSecondds, List<ScheduleStatus> statuses) {
        List<Schedule> schedules = this.scheduleDao.getAll();
        return Collections.unmodifiableList(schedules.stream().filter(schedule -> {
            return ((schedule.getNextRunAt().get() < currentTimeInMilliSecondds)
                        && (statuses.contains(schedule.getScheduleStatus())));
        }).collect(Collectors.toList()));
    }
}
