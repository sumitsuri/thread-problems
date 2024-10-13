package com.solution.lld.scheduler.cron;

import com.google.gson.JsonObject;
import com.solution.lld.scheduler.Constant;
import com.solution.lld.scheduler.model.Message;
import com.solution.lld.scheduler.model.Schedule;
import com.solution.lld.scheduler.service.JobSchedulerService;
import com.solution.lld.scheduler.service.PubSubService;
import com.solution.lld.scheduler.service.PubSubServiceImpl;
import com.solution.lld.scheduler.types.ScheduleStatus;

import java.util.Arrays;
import java.util.List;

public class JobSelectorCron implements Runnable{

    private JobSchedulerService jobSchedulerService = new JobSchedulerService();
    private PubSubService pubSubService;

    public JobSelectorCron(){
        this.jobSchedulerService = new JobSchedulerService();
        this.pubSubService = new PubSubServiceImpl();
    }

    @Override
    public void run() {
        //Select all schedule which are less than current time and in status(NEW, FAILED_RETRY):
        long currentTimeInMillisec = System.currentTimeMillis();
        List<Schedule> schedules = jobSchedulerService.getScheduleService().getSchedulesByStatus(currentTimeInMillisec, Arrays.asList(ScheduleStatus.NEW, ScheduleStatus.FAILED_RETRY));

        //can perform batching here.
        for(Schedule schedule : schedules){

            //Publish all schedule for execution to respective topic.
            JsonObject payload = new JsonObject();
            payload.addProperty("schedule-name", schedule.getName());
            Message message = Message.of(payload);
            this.pubSubService.publish(Constant.TopicConstant.EXECUTOR_TOPIC, message);

            //Update status as queued.
            this.jobSchedulerService.getScheduleService().updateScheduleStatus(schedule.getName(), ScheduleStatus.QUEUED);

        }
    }
}
