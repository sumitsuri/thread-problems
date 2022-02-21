package com.test.lld.covid.service.impl;

import com.google.gson.JsonObject;
import com.test.lld.covid.constant.AppConstant;
import com.test.lld.covid.model.Message;
import com.test.lld.covid.request.BookingRequest;
import com.test.lld.covid.request.SearchRequest;
import com.test.lld.covid.response.SearchResponse;
import com.test.lld.covid.service.BookingService;
import com.test.lld.covid.service.PubSubService;
import com.test.lld.covid.service.VaccinationService;

public class VaccinationServiceImpl implements VaccinationService {

    private BookingService bookingService;
    private PubSubService pubSubService;

    public VaccinationServiceImpl(BookingService bookingService, PubSubService pubSubService){
        this.bookingService = bookingService;
        this.pubSubService = pubSubService;
    }

    @Override
    public void bookSlot(BookingRequest bookingRequest) {
        String bookingId = bookingService.createBooking(bookingRequest);
        publishBookingCreationMessage(bookingRequest.isFirstDose(), bookingId);
    }

    @Override
    public void vaccinate(boolean isFirstDose, String bookingId) {
        bookingService.markBookingAsComplete(isFirstDose, bookingId);
        publishBookingCompletionMessage(isFirstDose, bookingId);
    }

    @Override
    public SearchResponse getAllAvailableSlots(SearchRequest searchRequest) {
        return bookingService.getAllAvailableSlots(searchRequest);
    }

    public void publishBookingCreationMessage(boolean isFirstDose, String bookingId){
        JsonObject payload = new JsonObject();
        payload.addProperty("booking-id", bookingId);
        payload.addProperty("is-first-dose", isFirstDose);
        Message message = new Message(payload);
        this.pubSubService.publish(AppConstant.SLOT_BOOKED_TOPIC, message);
    }

    public void publishBookingCompletionMessage(boolean isFirstDose, String bookingId){
        JsonObject payload = new JsonObject();
        payload.addProperty("booking-id", bookingId);
        payload.addProperty("is-first-dose", isFirstDose);
        Message message = new Message(payload);
        this.pubSubService.publish(AppConstant.VACCINATION_COMPLETED_TOPIC, message);
    }
}
