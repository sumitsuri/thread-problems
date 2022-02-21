package com.test.lld.covid.request;

import com.test.lld.covid.model.Slot;
import com.test.lld.covid.types.VaccineType;
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
