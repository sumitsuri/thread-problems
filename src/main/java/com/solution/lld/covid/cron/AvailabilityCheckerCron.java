package com.solution.lld.covid.cron;

import com.solution.lld.covid.model.Hospital;
import com.solution.lld.covid.request.SearchRequest;
import com.solution.lld.covid.service.BookingService;
import com.solution.lld.covid.service.HospitalService;

import java.util.List;
import java.util.Map;

public class AvailabilityCheckerCron implements Runnable{

    private BookingService bookingService;
    private HospitalService hospitalService;

    public AvailabilityCheckerCron(BookingService bookingService, HospitalService hospitalService){
        this.bookingService = bookingService;
        this.hospitalService = hospitalService;
    }

    @Override
    public void run() {
        System.out.println(String.format("[AvailabilityCheckerCron] running"));
        //get all user subscriptions
        //city + vaccines

        //check availabilty in those zip or hospital and if available send notification

        //get all zipcodes and check availabilty.
        Map<String, List<Hospital>> allZipBasedHospitals = hospitalService.getAllWithZipCode();
        for(String zip : allZipBasedHospitals.keySet()){
            SearchRequest searchRequest = SearchRequest.builder().zipCode(zip).build();
            bookingService.getAllAvailableSlots(searchRequest);
        }

        //Print out availabity
        //In real-time, this will be replaced by sending message to topic so that push-notification
        //can notify subscribed users.
    }
}
