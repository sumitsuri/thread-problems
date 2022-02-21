package com.test.lld.covid;

import com.test.lld.covid.cron.AvailabilityCheckerCron;
import com.test.lld.covid.service.*;
import com.test.lld.covid.service.impl.*;
import com.test.lld.scheduler.cron.JobSelectorCron;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {

        //Data generation part


        //create users.

        //create hospitals

        //check slot-availabilty

        //create bookings for users

        //check slot availabilty.

        UserService userService = new UserServiceImpl();
        HospitalService hospitalService = new HospitalServiceImpl();
        BookingService bookingService = new BookingServiceImpl(userService, hospitalService);

        TopicService topicService = new TopicServiceImpl();
        PubSubService pubSubService = new PubSubServiceImpl(topicService);

        ScheduledThreadPoolExecutor threadPool
                = new ScheduledThreadPoolExecutor(1);
        threadPool.schedule(new AvailabilityCheckerCron(bookingService, hospitalService), 1, TimeUnit.MINUTES);
    }
}
