package com.test.lld.covid.service;

import com.test.lld.covid.request.BookingRequest;
import com.test.lld.covid.request.SearchRequest;
import com.test.lld.covid.response.SearchResponse;

public interface VaccinationService {

    public void bookSlot(BookingRequest bookingRequest);

    public void vaccinate(boolean isFirstDose, String bookingId);

    public SearchResponse getAllAvailableSlots(SearchRequest searchRequest);
}
