package com.solution.lld.covid.service;

import com.solution.lld.covid.model.Booking;
import com.solution.lld.covid.request.BookingRequest;
import com.solution.lld.covid.request.SearchRequest;
import com.solution.lld.covid.response.SearchResponse;

import java.util.List;

public interface BookingService {

    public Booking get(String id);

    public List<Booking> getAll();

    public void update(String id, BookingRequest bookingRequest);

    public String createBooking(BookingRequest bookingRequest);

    public void markBookingAsComplete(boolean isFirstDose, String bookingId);

    public SearchResponse getAllAvailableSlots(SearchRequest searchRequest);

}
