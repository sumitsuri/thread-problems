package com.test.lld.covid.response;

import com.test.lld.covid.model.Slot;
import com.test.lld.covid.model.Vaccine;
import com.test.lld.covid.types.VaccineType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class SearchResponse {

    /**
     * hospital
     * slot : vaccine
     */
    private List<VaccineSlot> vaccineSlots;

    public SearchResponse(List<VaccineSlot> vaccineSlots){
        this.vaccineSlots = vaccineSlots;
    }

    public static VaccineSlot ofVaccineSlot(String hospitalName, Map<Slot, Map<VaccineType, AtomicInteger>> availableSlots){
        return VaccineSlot.builder().hospitalName(hospitalName).availableSlots(availableSlots).build();
    }

    @Getter
    @Setter
    @Builder
    public static class VaccineSlot{
        private String hospitalName;
        private Map<Slot, Map<VaccineType, AtomicInteger>> availableSlots;
    }
}
