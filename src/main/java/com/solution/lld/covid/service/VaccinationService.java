package com.solution.lld.covid.service;

import com.solution.lld.covid.request.BookingRequest;
import com.solution.lld.covid.request.SearchRequest;
import com.solution.lld.covid.response.SearchResponse;

public interface VaccinationService {

    public void bookSlot(BookingRequest bookingRequest);

    public void vaccinate(boolean isFirstDose, String bookingId);

    public SearchResponse getAllAvailableSlots(SearchRequest searchRequest);
}
