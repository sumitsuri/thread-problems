package com.solution.lld.covid.request;

import com.solution.lld.covid.model.Slot;
import com.solution.lld.covid.types.VaccineType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class BookingRequest {

    private String hospitalName;
    private String bookedBy;
    private Slot slot;
    private List<String> bookedForIds;
    private VaccineType vaccineType;
    private boolean isFirstDose;
}
