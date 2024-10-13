package com.solution.lld.covid.model;

import com.solution.lld.covid.types.VaccineStatus;
import com.solution.lld.covid.types.VaccineType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Booking {

    private String id;
    private User bookedByUser;
    private VaccineType vaccineType;
    private Slot slot;
    private Hospital hospital;
    private List<String> bookedFor;
    private VaccineStatus vaccineStatus;
    private long nextVaccinationDate;
    private long createdOn;

    public Booking(User bookedByUser, VaccineType vaccineType, Slot slot, Hospital hospital, List<String> bookedFor){
        //Preconditions check
        this.id = UUID.randomUUID().toString();
        this.bookedByUser = bookedByUser;
        this.slot = slot;
        this.hospital = hospital;
        this.bookedFor = bookedFor;
        this.vaccineType = vaccineType;
        this.vaccineStatus = VaccineStatus.BOOKED;
        this.createdOn = System.currentTimeMillis();
    }
}
