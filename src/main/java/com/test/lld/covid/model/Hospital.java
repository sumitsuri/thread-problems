package com.test.lld.covid.model;

import com.test.lld.covid.types.VaccineType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class Hospital {

    private String id;
    private String name;
    private Address address;
    private Map<Slot, Map<VaccineType, AtomicInteger>> vaccines;

    public Hospital(String name, Address address) {
        //Preconditions check
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
    }
}
