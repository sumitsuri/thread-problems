package com.solution.lld.scheduler.handler;

import com.solution.lld.scheduler.model.Job;
import com.solution.lld.scheduler.model.Message;
import com.solution.lld.scheduler.model.Schedule;
import com.solution.lld.scheduler.service.JobSchedulerService;
import com.solution.lld.scheduler.types.ScheduleStatus;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class JobExecutorHandler implements Handler{

    JobSchedulerService jobSchedulerService = new JobSchedulerService();

    @Override
    public void handle(List<Message> messages) {

        for(Message message : messages){
            String scheduleName = message.getMessage().get("schedule-name").getAsString();
            Schedule schedule = jobSchedulerService.getScheduleService().getSchedule(scheduleName);

            Job job = jobSchedulerService.getJobService().getJob(schedule.getJobName());

            //Update schedule st
            try{
                job.getHandler().handle(job);
            }finally{
                AtomicLong nextSchedule = schedule.getNextSchedule(System.currentTimeMillis());
                schedule.setNextRunAt(nextSchedule);
                schedule.setScheduleStatus(ScheduleStatus.SUCCESSFUL);
            }


            //Add retry logic on failure



        }
    }
}
